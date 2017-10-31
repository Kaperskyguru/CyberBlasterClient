package CyberBlasterClient.Dashboard;

import CyberBlasterClient.Order.Order;
import CyberBlasterClient.ChangePassword.Password;
import CyberBlasterClient.TopupTicket.TopUp;
import CyberBlasterClient.Chat.ChatFrame;
import Cyber_Cafe_Management.Client.ClientLoginForm;
import Cyber_Cafe_Management.Client.DBClient;
import Cyber_Cafe_Management.Client.Message;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.Timer;

public final class ClientDashboard extends javax.swing.JFrame {

    public Socket socket;
    public ObjectOutputStream output;
    public ObjectInputStream input;
    private Message message = new Message();
    private DBClient DB = new DBClient();
    public Timer ClientTimer;

    public ClientDashboard() {
        initComponents();
        lblTicketName.setText(message.getTicketLogin());
        Timing();
        storeData();
        message.getBackgroundMessage();

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                LogoutMethed();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                sendLogoutDetails("LogOff", Message.getUniqueSessionId() + "/" + socket.getLocalPort());
            }

        });
    }

    public ClientDashboard(final Socket socket) {
        this.socket = socket;
        initComponents();
        lblPrepaid.setText("" + Message.getTicketPrice());
        lblTicketName.setText(message.getTicketLogin());
        message.getBackgroundMessage();
        Timing();
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                LogoutMethed();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                sendLogoutDetails("shutoff", Message.getUniqueSessionId() + "/" + socket.getLocalPort());

            }

        });

//        storeData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTicketName = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        pricing = new javax.swing.JLabel();
        payment = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblTime = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtTimeLeft = new javax.swing.JTextField();
        lblPrepaid = new javax.swing.JLabel();
        lblTimeBox = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblTraffic = new javax.swing.JLabel();
        lblOthers = new javax.swing.JLabel();
        lblSum = new javax.swing.JLabel();
        lblTax = new javax.swing.JLabel();
        lblRounding = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CyberBlaster Client");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setText("Login");

        jLabel2.setText("Name");

        jLabel3.setText("Pricing");

        jLabel4.setText("Payment");

        lblTicketName.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblTicketName.setText("Admin");

        name.setText("Solo");

        pricing.setText("Standard");

        payment.setText("Pre-Paid");

        jLabel9.setText("Pre-Paid");

        lblTime.setText("Time");

        jLabel11.setText("Traffic");

        jLabel12.setText("Others");

        jLabel13.setText("Sum");

        jLabel14.setText("Tax");

        jLabel15.setText("Balance");

        jLabel16.setText("Rounding");

        jLabel17.setText("Total");

        jButton1.setText("Top Up...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Chat...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Order...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Password...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Log Off");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtTimeLeft.setEditable(false);
        txtTimeLeft.setBackground(new java.awt.Color(153, 153, 153));
        txtTimeLeft.setForeground(new java.awt.Color(255, 255, 255));
        txtTimeLeft.setText("Time Left:");
        txtTimeLeft.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblPrepaid.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblPrepaid.setText("2343423423");

        lblTimeBox.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblTimeBox.setText("3234234234");

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel20.setText("0");

        jLabel21.setText("0");

        jLabel22.setText("0");

        jLabel23.setText("0");

        jLabel24.setText("0");

        jLabel25.setText("0");

        jLabel26.setText("0");

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel27.setText("0");

        jLabel28.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel28.setText("0");

        lblTraffic.setText("0");

        lblOthers.setText("0");

        lblSum.setText("0");

        lblTax.setText("0");

        lblRounding.setText("0");

        lblTotal.setText("0");

        lblBalance.setText("0");

        javax.swing.GroupLayout MainPaneLayout = new javax.swing.GroupLayout(MainPane);
        MainPane.setLayout(MainPaneLayout);
        MainPaneLayout.setHorizontalGroup(
            MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(MainPaneLayout.createSequentialGroup()
                        .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jSeparator6))
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPaneLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(lblPrepaid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20))
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator4)
                            .addGroup(MainPaneLayout.createSequentialGroup()
                                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(payment)
                                    .addComponent(pricing)
                                    .addComponent(name)
                                    .addComponent(lblTicketName)
                                    .addComponent(txtTimeLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 17, Short.MAX_VALUE))
                            .addGroup(MainPaneLayout.createSequentialGroup()
                                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTime)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(24, 24, 24)
                                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblOthers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTraffic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTimeBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(MainPaneLayout.createSequentialGroup()
                                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(36, 36, 36)
                                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblTax, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                    .addComponent(lblSum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(MainPaneLayout.createSequentialGroup()
                                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MainPaneLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblBalance, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MainPaneLayout.createSequentialGroup()
                                        .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel17))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                            .addComponent(lblRounding, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        MainPaneLayout.setVerticalGroup(
            MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPaneLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTicketName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pricing))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(payment))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jButton1)
                    .addComponent(lblPrepaid)
                    .addComponent(jLabel20))
                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPaneLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23))
                    .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPaneLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTime)
                                .addComponent(jButton3)
                                .addComponent(lblTimeBox))
                            .addGap(0, 0, 0)
                            .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(lblTraffic))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(lblOthers)))
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPaneLayout.createSequentialGroup()
                        .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel24)
                            .addComponent(lblSum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel25)
                            .addComponent(lblTax))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPaneLayout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(17, 17, 17)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jButton5)
                    .addComponent(jLabel26)
                    .addComponent(lblRounding))
                .addGap(1, 1, 1)
                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(lblTotal)))
                .addGap(4, 4, 4)
                .addGroup(MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel28)
                    .addComponent(lblBalance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimeLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        getContentPane().add(MainPane, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new TopUp(this, false).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Order(this, false).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new ChatFrame("solomon", socket.getInetAddress().getHostName(), socket.getLocalPort()).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Password(this, false).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        sendLogoutDetails("LogOff", Message.getUniqueSessionId() + "/" + socket.getLocalPort());
        LogoutMethed();
    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblOthers;
    private javax.swing.JLabel lblPrepaid;
    private javax.swing.JLabel lblRounding;
    private javax.swing.JLabel lblSum;
    private javax.swing.JLabel lblTax;
    public static javax.swing.JLabel lblTicketName;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTimeBox;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTraffic;
    private javax.swing.JLabel name;
    private javax.swing.JLabel payment;
    private javax.swing.JLabel pricing;
    private javax.swing.JTextField txtTimeLeft;
    // End of variables declaration//GEN-END:variables

    public static int count1 = Message.getPeriod();
    int countSeconds = 60;
    int c;

    public void Timing() {
        ClientTimer = new Timer(1000, checkClientCurrentTime);
        ClientTimer.start();
        c++;

    }

    ActionListener checkClientCurrentTime = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            lblPrepaid.setText("" + Message.getTicketPrice());
            countSeconds--;
            lblTimeBox.setText("" + count1 + ":" + countSeconds);
            message.time(count1, countSeconds);
            if (countSeconds == 0 && count1 != 0) {

                count1--;
                countSeconds = 60;
                if (c == 5) {
                    message.time(count1, countSeconds);
                }
                c = 0;
            } else if (count1 == 0 && countSeconds == 0) {
                ClientTimer.stop();
                dispose();
                new ClientLoginForm().setVisible(true);

            }

        }
    };

    public static int getTme() {
        return count1;
    }

    private void LogoutMethed() {
        ClientTimer.stop();
        dispose();
        ClientLoginForm C = new ClientLoginForm();
        C.setVisible(true);

    }

    private void sendLogoutDetails(String message, String session) {
        Message.setTicketTime("exit/" + message, "exitby/" + session);
    }

    public void updateTimr() {
        new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Message.setTicketTime(count1, count1);

            }
        }).start();
    }

    private void storeData() {
//        int ticketname = Integer.parseInt(lblTicketName.getText());
        String name1 = name.getText();
        int price = Integer.valueOf(pricing.getText());
        String pay = payment.getText();
        int prepaid = Integer.valueOf(lblPrepaid.getText());
        int time = Integer.parseInt(lblTimeBox.getText());
        int sum = Integer.parseInt(lblSum.getText());
        int others = Integer.parseInt(lblOthers.getText());
        double balance = Double.valueOf(lblBalance.getText());
        double rounding = Double.valueOf(lblRounding.getText());
        double tax = Double.valueOf(lblTax.getText());
        int total = Integer.parseInt(lblTotal.getText());
        int traffic = Integer.parseInt(lblTraffic.getText());
        String address = socket.getLocalAddress().getHostAddress();
        //    DB.storeClientDetails(address, ticketname, time, rounding, total, balance, tax, sum, others, traffic, ticketname, name1, price, pay, prepaid);
    }
}
