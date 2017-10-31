package CyberBlasterClient.Chat;

import Cyber_Cafe_Management.Client.DBClient;
import Cyber_Cafe_Management.Client.Message;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatFrame extends javax.swing.JFrame {

    private ObjectInputStream input;
    private static String name, address;
    private int port;
    private Thread send;
    private DBClient DB = new DBClient();

    public ChatFrame() {
        initComponents();
    }

    public ChatFrame(String name, String address, int port) {
        initComponents();
        this.name = name;
        this.address = address;
        this.port = port;
        displayMessage("Connected to " + name + " " + address + " " + port + "");
        if (!new Message().getMessage().equals("") || new Message().getMessage() != null) {
            displayMessage(new Message().getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTxtRMessage = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtRHistory = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chat");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new java.awt.BorderLayout(0, 3));

        jPanel1.setLayout(new java.awt.BorderLayout(50, 0));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTxtRMessage.setColumns(20);
        jTxtRMessage.setLineWrap(true);
        jTxtRMessage.setRows(5);
        jTxtRMessage.setText("Type your Message here");
        jTxtRMessage.setToolTipText("Type your Message here");
        jTxtRMessage.setWrapStyleWord(true);
        jTxtRMessage.setAutoscrolls(false);
        jTxtRMessage.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(jTxtRMessage);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jButton2.setText("Send");
        jButton2.setSelected(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTxtRHistory.setEditable(false);
        jTxtRHistory.setColumns(20);
        jTxtRHistory.setLineWrap(true);
        jTxtRHistory.setRows(5);
        jTxtRHistory.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTxtRHistory);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //String message = jTxtRMessage.getText();
        //DB.storeChatLog(address, name, message, port);
        displayMessage(name + ": " + jTxtRMessage.getText());
        String mess = "chat/" + jTxtRMessage.getText();
        send(mess);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextArea jTxtRHistory;
    private javax.swing.JTextArea jTxtRMessage;
    // End of variables declaration//GEN-END:variables

    private String recieve() {
        String text = null;
        try {
            text = (String) input.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String message = text;
        return message;

    }

    private void send(final Object data) {
        send = new Thread("sending Thread") {
            @Override
            public void run() {
                Message.setTicketTime(data, "sender/" + Message.getUniqueSessionId());
            }
        };
        send.start();
    }

    public static void displayMessage(final String text) {
        jTxtRHistory.append(text + "\n");
    }
}
