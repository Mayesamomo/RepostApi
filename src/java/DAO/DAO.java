package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author micha
 */
public class DAO {
   //  protected String database;

    //public DAO(String database) {
     //  this.database = database;
   // }
     public Connection getConnection() throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/repostit";//+ database;
        String username = "root";
        String password = "";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException ex) {
           System.out.println("Connection failed " + ex.getMessage());
           System.exit(1);

        } catch (SQLException ex2) {
            System.out.println("Connection failed " + ex2.getMessage());
            System.exit(2);
        }
        return con;
    }

    public void freeConnection(Connection con) throws SQLException {
        try {
            if (con != null) {
                con.close();
                con = null;

            }
        } catch (SQLException e) {
            System.out.println("Failed to free connection: " + e.getMessage());
            System.exit(1);
        }

    }
}
