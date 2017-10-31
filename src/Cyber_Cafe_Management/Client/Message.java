package Cyber_Cafe_Management.Client;

import CyberBlasterClient.Dashboard.ClientDashboard;
import CyberBlasterClient.ChangePassword.Password;
import CyberBlasterClient.Chat.ChatFrame;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Message {

    // public Socket socket;
    private static ObjectInputStream input;
    private static ObjectOutputStream output;
    public static Socket socket;
    private static String message;
    private static double ticketPrice;
    String prepaid;
    String time, text;
    static Thread chat, get;
    static int count, UniqueSessionId;

    public static int period, lastmin;
    public static int minutes, seconds;
    private String ticketLogin;
    private static Vector storeItems;

    public Message(String message) {
        this.message = message;

    }

    public Message() {

    }

    public static void setUpMessageClass(Socket socket, int count) {
        Message.socket = socket;
        //   this.count = count;
    }

    private void setMessage(String message) {
        Message.message = message;

    }

    public static void sendClientMessage(int message1, String message2) {
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(message1);
            output.writeObject(message2);
            output.flush();

        } catch (IOException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getServerMessage() {
        String object;
        try {
            while (true) {

                input = new ObjectInputStream(socket.getInputStream());

                String tr = (String) input.readObject();

                switch (tr) {
                    case "true":
                        period = (int) input.readObject();
                        UniqueSessionId = (int) input.readObject();
                        String ticketPrice1 = String.valueOf(input.readObject());
                        Double price = Double.valueOf(ticketPrice1);
                        setTicketPrice(price);
                        Vector rs = (Vector) input.readObject();
                        setStoreItem(rs);

                        // send a succesfull message here....
                        String message1 = "m/success";
                        String sender = "sux" + "/" + Message.getUniqueSessionId();

                        setTicketTime(sender, message1);

                        object = "true";
                        count++;
                        return object;
                    case "false":
                        object = "false";
                        return object;
                    case "Ticket Used Up":
                        object = "Ticket Used Up";
                        return object;
                    case "Ticket Expired":
                        object = "Ticket Expired";
                        return object;
                    case "true1":
                }

                getBackgroundMessage();
                break;
            }

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void getBackgroundMessage() {
        chat = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        message = (String) input.readObject();
                        String session = message.split("/")[0];
                        String key = message.split("/")[1];
                        String text = message.split("/")[2];
                        if (Integer.parseInt(session) == getUniqueSessionId()) {
                            processSingleMessage(key, text);
                        } else if (Integer.parseInt(session) == 9080) {
                            processGeneralMessage(key, text);
                        }
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        };
        chat.start();
    }

    private void processGeneralMessage(String key, String text) {
        if (key.equals("message")) {
            this.text = text;
            setMessage("General: " + text);
            ChatFrame.displayMessage("General: " + text);
        } else if (key.equals("shut")) {

            if (text.equals("shutdown_all")) {
                shutdown();
            } else {
                restart();
            }
        }

    }

    private void processSingleMessage(String key, String text) {
        switch (key) {
            case "chat":
                this.text = text;
                ChatFrame.displayMessage("Admin: " + text);
                break;
            case "shut":
                processShutdown(text);
                break;
            case "topup":
                processTopup(text);
                break;
            case "chnPass":
                Password.note.setText(text);
        }
    }

    private static void processTopup(String text) {
        if (text.startsWith("Your")) {
        } else {
            int period1 = Integer.parseInt(text.split(",")[0]);
            Double price = Double.valueOf(text.split(",")[1]);
            setTicketPrice(price);
            setPeriod(period1);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public String getMessage() {
        if (message == null) {
            return "";
        }
        return message;
    }

    public static int getPeriod() {
        if (period == 0) {
            return 0;
        }
        return period;
    }

    private static void processShutdown(String text) {
        switch (text) {
            case "shutdown":
                shutdown();
                break;
            case "turnoff":
                turnoff();
                break;
            case "restart":
                restart();
                break;
            case "sleep":
                sleepComputer();
                break;
            default:
                break;
        }
    }

    public static void setPeriod(int p) {
        ClientDashboard.count1 += p;
    }

    public void time(final int min, final int sec) {
        if (count >= 0) {

            try {
                setTicketTime(min, sec);
            } catch (Exception ex) {
                Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
//                try {
//                    output1.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        }

    }

    public static void setTicketTime(final Object minutes, final Object seconds) {
        Thread timeThread = new Thread("timeThread") {
            @Override
            public void run() {
                try {
                    ObjectOutputStream output1 = new ObjectOutputStream(socket.getOutputStream());
                    output1.writeObject(minutes);
                    output1.writeObject(seconds);
                    output1.flush();
                } catch (IOException ex) {
                    Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        };
        timeThread.start();

    }

    public void setTicketLogin(String text) {
        ticketLogin = text;
    }

    public String getTicketLogin() {
        return ticketLogin;
    }

    private String getCurrentDate() {
        GregorianCalendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String date = "" + day + "/" + month + "/" + year + "";
        return date;

    }

    public static void topUp(int lastMin, String ticketLogin, String TicketPass) {
        lastmin = lastMin;
        setTicketTime(ticketLogin, TicketPass);
        //send(ticketLogin + "/e/" + TicketPass);
    }

    public static int getUniqueSessionId() {
        return UniqueSessionId;
    }

    private static void shutdown() {
        try {
            Runtime r = Runtime.getRuntime();
            r.exec("shutdown.exe  -s -f");

        } catch (IOException ex) {
            Logger.getLogger(Message.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void turnoff() {
        try {
            Runtime r = Runtime.getRuntime();
            r.exec("shutdown.exe  -l");

        } catch (IOException ex) {
            Logger.getLogger(Message.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void restart() {
        try {
            Runtime r = Runtime.getRuntime();
            r.exec("shutdown.exe  -r");

        } catch (IOException ex) {
            Logger.getLogger(Message.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void sleepComputer() {
        try {
            Runtime r = Runtime.getRuntime();
            r.exec("shutdown.exe  -h");

        } catch (IOException ex) {
            Logger.getLogger(Message.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getChat() {
        return text;
    }

    private void setStoreItem(Vector items) {
        storeItems = items;
    }

    public static Vector getStoreItem() {
        return storeItems;
    }

    private static void setTicketPrice(Double price) {
        ticketPrice += price;
    }

    public static double getTicketPrice() {
        return ticketPrice;
    }
}
