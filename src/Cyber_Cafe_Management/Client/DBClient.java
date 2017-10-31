package Cyber_Cafe_Management.Client;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBClient {

    public static Connection con;
    public Statement st;
    public ResultSet rs;

    public DBClient() {

    }

    public static Connection connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyberblasterdbClient", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void storeChatLog(String ip, String login, String Message, int port) {
        try {
            st = connection().createStatement(ResultSet.CONCUR_UPDATABLE, ResultSet.TYPE_SCROLL_INSENSITIVE);
            rs = st.executeQuery("select * from chatlog");
            rs.moveToInsertRow();
            rs.updateString("ipaddress", ip);
            rs.updateInt("Port", port);
            rs.updateString("Name", login);
            rs.updateString("Message", Message);
            rs.insertRow();

        } catch (SQLException ex) {
            Logger.getLogger(DBClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void storeClientDetails(String ip, int ticketID, int min, double rounding, int total, double balance, double tax, int sum, int others, int traffic, int login, String name, int pricing, String payment, int prepaid) {
        try {
            st = connection().createStatement(ResultSet.CONCUR_UPDATABLE, ResultSet.TYPE_SCROLL_INSENSITIVE);
            rs = st.executeQuery("select * from cliendetails");
            rs.moveToInsertRow();
            rs.updateString("ipaddress", ip);
            rs.updateInt("TicketID", ticketID);
            rs.updateString("Name", name);
            rs.updateString("Payment", payment);
            rs.updateInt("Minutes", min);
            rs.updateInt("Pricing", pricing);
            rs.updateInt("Prepaid", prepaid);
            rs.updateInt("Traffic", traffic);
            rs.updateInt("Others", others);
            rs.updateDouble("Tax", tax);
            rs.updateDouble("Rounding", rounding);
            rs.updateInt("Total", total);
            rs.updateDouble("Balance", balance);
            rs.updateDouble("Rounding", rounding);
            rs.insertRow();

        } catch (SQLException ex) {
            Logger.getLogger(DBClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void storeClientTime(String ip, int ticketID, int min, int sec, int unique) {
        try {
            st = connection().createStatement(ResultSet.CONCUR_UPDATABLE, ResultSet.TYPE_SCROLL_INSENSITIVE);
            rs = st.executeQuery("select * from timertableclient");
            rs.moveToInsertRow();
            rs.updateString("ipaddress", ip);
            rs.updateInt("TicketID", ticketID);
            rs.updateInt("Minutes", min);
            rs.updateInt("Seconds", sec);
            rs.updateInt("uniquenumber", unique);
            rs.insertRow();

        } catch (SQLException ex) {
            Logger.getLogger(DBClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
