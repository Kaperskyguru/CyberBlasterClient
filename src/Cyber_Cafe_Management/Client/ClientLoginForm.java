package Cyber_Cafe_Management.Client;

import CyberBlasterClient.Dashboard.ClientDashboard;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientLoginForm extends javax.swing.JFrame {

    private boolean mousePressed = false;
    int mouseX, mouseY;
    static boolean running = false, isframebool = false;

    private ObjectInputStream input, fromClient;
    private ObjectOutputStream output, toClient;
    Message message;
    private Thread runClientServer, manageClient, recieveFromServer;
    public ServerSocket server;
    public Socket clientSocket;
    public Socket socket;
    int count = 0;

    public ClientLoginForm() {
        initComponents();
        message = new Message();
        TaskKill();
        MouseDrag();

        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        Main_Panel.setLocation((this.getWidth() * 1) + 60, this.getHeight() - 60);
        Main_Panel.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Main_Panel = new javax.swing.JPanel();
        TopPane = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BottomPane = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lblStatusBar = new javax.swing.JLabel();
        CenterPane = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addContainerGap(299, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CyberBlaster");
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        Main_Panel.setAlignmentX(0.0F);
        Main_Panel.setAlignmentY(0.0F);
        Main_Panel.setLayout(new java.awt.BorderLayout());

        TopPane.setBackground(new java.awt.Color(204, 204, 255));
        TopPane.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 2, new java.awt.Color(153, 153, 153)));

        jLabel9.setText("CyberBlaster v1.0");

        javax.swing.GroupLayout TopPaneLayout = new javax.swing.GroupLayout(TopPane);
        TopPane.setLayout(TopPaneLayout);
        TopPaneLayout.setHorizontalGroup(
            TopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(303, Short.MAX_VALUE))
        );
        TopPaneLayout.setVerticalGroup(
            TopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPaneLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        Main_Panel.add(TopPane, java.awt.BorderLayout.PAGE_START);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CyberBlaster");
        Main_Panel.add(jLabel2, java.awt.BorderLayout.CENTER);

        BottomPane.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 2, 2, new java.awt.Color(153, 153, 153)));

        jButton1.setText("Option >>");

        jButton2.setText("Enter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lblStatusBar.setEnabled(false);

        javax.swing.GroupLayout BottomPaneLayout = new javax.swing.GroupLayout(BottomPane);
        BottomPane.setLayout(BottomPaneLayout);
        BottomPaneLayout.setHorizontalGroup(
            BottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BottomPaneLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(BottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BottomPaneLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, Short.MAX_VALUE))
        );
        BottomPaneLayout.setVerticalGroup(
            BottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BottomPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Main_Panel.add(BottomPane, java.awt.BorderLayout.PAGE_END);

        CenterPane.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 2, new java.awt.Color(153, 153, 153)));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel3.setText("PC1");

        jLabel4.setText("Login");

        jLabel5.setText("Password");

        jLabel6.setText("Language");

        txtLogin.setFocusCycleRoot(true);
        txtLogin.setFocusTraversalPolicyProvider(true);
        txtLogin.setPreferredSize(new java.awt.Dimension(20, 20));
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginKeyPressed(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CyberBlasterClient/Icons/glyphicons-45-keys.png"))); // NOI18N
        jLabel8.setIconTextGap(10);

        javax.swing.GroupLayout CenterPaneLayout = new javax.swing.GroupLayout(CenterPane);
        CenterPane.setLayout(CenterPaneLayout);
        CenterPaneLayout.setHorizontalGroup(
            CenterPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CenterPaneLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CenterPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CenterPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CenterPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CenterPaneLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(CenterPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CenterPaneLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(40, 40, 40)
                                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CenterPaneLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtPassword)))))
                .addGap(98, 98, 98))
        );
        CenterPaneLayout.setVerticalGroup(
            CenterPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CenterPaneLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CenterPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CenterPaneLayout.createSequentialGroup()
                        .addGroup(CenterPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addGap(13, 13, 13)
                        .addGroup(CenterPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CenterPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(CenterPaneLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 58, Short.MAX_VALUE))))
        );

        Main_Panel.add(CenterPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(Main_Panel);
        Main_Panel.setBounds(0, 0, 404, 271);

        setSize(new java.awt.Dimension(400, 291));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        message.setTicketLogin(txtLogin.getText());
        try {
            Connect();
            verifyOverNetworkDb();
            sendUpdates();
            socket.setKeepAlive(true);
        } catch (SocketException ex) {
            Logger.getLogger(ClientLoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyPressed

    }//GEN-LAST:event_txtLoginKeyPressed

    public void MouseDrag() {

        TopPane.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                mousePressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
            }

        });

        TopPane.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (mousePressed = true) {
                    int x = e.getXOnScreen();
                    int y = e.getYOnScreen();
                    Main_Panel.setLocation(x - mouseX, y - mouseY);
                }

            }

        });
    }

    public void TaskKill() {
        try {
            String[] task = {"taskkill.exe", "/im", "explorer.exe"};
            Runtime run = Runtime.getRuntime();
            run.exec(task);
        } catch (IOException ex) {
            Logger.getLogger(ClientLoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientLoginForm().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BottomPane;
    private javax.swing.JPanel CenterPane;
    private javax.swing.JPanel Main_Panel;
    private javax.swing.JPanel TopPane;
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lblStatusBar;
    public javax.swing.JTextField txtLogin;
    public javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables

    public void Connect() {
        // runClientServer = new Thread(new Runnable() {
        //  @Override
        //  public void run() {
        try {

            socket = new Socket("localhost", 9080);
            count++;
            Message.setUpMessageClass(socket, count);
        } catch (IOException ex) {
            lblStatusBar.setText(ex.getMessage());
            Logger.getLogger(ClientLoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void verifyOverNetworkDb() {

        int login = Integer.parseInt(txtLogin.getText());
        String pass = txtPassword.getText();
        Message.sendClientMessage(login, pass);
        recieveFromNetwork();
    }

    public void recieveFromNetwork() {
        String mess = (String) message.getServerMessage();
        switch (mess) {
            case "true":
                this.setVisible(false);
                new ClientDashboard(this.socket).setVisible(true);
                isframebool = true;
                break;
            case "false":
                lblStatusBar.setText("Incorrect Username and Password");
                break;

            case "Ticket Used Up":
                lblStatusBar.setText("Ticket Used Up");
                break;
            case "Ticket Expired":
                lblStatusBar.setText("Ticket Expired");
        }

    }

    private void sendUpdates() {

    }

}
