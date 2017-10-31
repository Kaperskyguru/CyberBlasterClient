package CyberBlasterClient.Order;

import CyberBlasterClient.Dashboard.ClientDashboard;
import Cyber_Cafe_Management.Client.Message;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Order extends javax.swing.JDialog {

    public Order(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        storeItems();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpQty = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Order");
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(343, 268));
        setResizable(false);
        getContentPane().setLayout(null);

        jSpQty.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpQty.setValue(1);
        getContentPane().add(jSpQty);
        jSpQty.setBounds(50, 190, 50, 20);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(310, 210));

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Price", ""
            }
        ));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(180);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 340, 179);

        jLabel1.setText("Item(s)");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 190, 50, 20);

        jButton1.setText("Ok");
        jButton1.setPreferredSize(new java.awt.Dimension(65, 23));
        jButton1.setSelected(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(160, 230, 70, 23);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(250, 230, 65, 23);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 220, 340, 10);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String name = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 1);
        int ID = Integer.parseInt((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        int quantity = Integer.parseInt(jSpQty.getModel().getValue().toString());
        sendPurchase(name, ID, quantity);
        dispose();


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpQty;
    public static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void storeItems() {

        Vector<String> header = new Vector<>();
        header.add("ID");
        header.add("Name");
        header.add("Available");
        header.add("Price");
        jTable1.setModel(new DefaultTableModel(Message.getStoreItem(), header));
    }

    private void sendPurchase(String name, int ID, int quantity) {
        String message = "order/" + name + "/" + ID + "/" + quantity;
        int sender = Message.getUniqueSessionId();
        Message.setTicketTime(message, sender);
    }

}
