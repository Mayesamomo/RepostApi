package DAO;

import DTO.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author micha
 */
public class UserDAO extends DAO implements UserInterface {

    private static final UserDAO ourInstance = new UserDAO();

    public static UserDAO getInstance() {
        return ourInstance;
    }
    // public UserDAO(String database) {
    //  super(database);
    //}
//returns a user with the given user Id
///git a specific user with a specific ID

    public static void main(String[] args) {
        ///User us = new User("Khlaus Michaelson","Khlaus","khlaus@gmail.com","password");
        UserDAO dao = new UserDAO();
        String username = "modric";
        String email = "animegang@gmail.com";
        String password = "password";

        // System.out.println(dao.register(us));

    }

    @Override
    public List<User> getUsers(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList();

        try {
            con = getConnection();
            String query = "Select user_id,fullName,user_name,email,user_type,user_status,date from users where user_id =" + id;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                User c = new User(rs.getInt("user_id"),
                        rs.getString("fullName"),
                        rs.getString("user_name"),
                        rs.getString("email"),
                        rs.getString("user_type"),
                        rs.getInt("user_status"),
                        rs.getString("date"));
                users.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getUser(Users use) method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getUsers(Users user) method: " + e.getMessage());
            }
        }
        return users;
    }

    //returns all users
    @Override
    public ArrayList<User> getAllUsers() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList();
        try {
            con = getConnection();
            String query = "Select user_id,fullName,user_name,email,user_type,user_status,date from users";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt("user_id"),
                        rs.getString("fullName"),
                        rs.getString("user_name"),
                        rs.getString("email"),
                        rs.getString("user_type"),
                        rs.getInt("user_status"),
                        rs.getString("date"));

                users.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllUsers() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getAllUsers() method: " + e.getMessage());
            }
        }
        return users;
    }

    //check if user exists in the database
    @Override
    public boolean checkIfExist(String username, String email) {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        // ArrayList<User> users = new ArrayList();
        boolean flag = false;
        try {
            con = getConnection();
//checking to see if username already exist in the database
            String query = "select user_name,email from users where user_name = ? AND email =?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            rs = ps.executeQuery();
            //set a counter to loop through the available users in the database
            //int count = 0;
            if (rs.next()) {

                flag = true;
                return flag;
            } else {

                flag = false;
                return flag;
            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the checkIfExist() method: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean register(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //ArrayList<User> users = new ArrayList();
        boolean flag;
        if (!checkIfExist(user.getUsername(), user.getEmail())) {
            try {
                // Get a statement from the connection
                con = getConnection();
                ps = con.prepareStatement("insert into users (fullName,user_name,email,password) values (?, ?, ?, ?)");
                ps.setString(1, user.getFullName());
                ps.setString(2, user.getUsername());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPassword());
                // Execute the query
                ps.executeUpdate();
                //rs = ps.getGeneratedKeys();
                flag = true;
                return flag;
                //System.out.println(" Account created");
                //users.add(user);

            } catch (SQLException e) {
                System.out.println("Exception occured in the register() method: " + e.getMessage());
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        freeConnection(con);
                    }
                } catch (SQLException e) {
                    System.out.println("Exception occured in the finally section of the register() method: " + e.getMessage());
                }
            }
        } else {
            flag = false;
            return flag;

        }

        return false;

    }

    @Override
    public boolean login(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList();
        boolean flag;
        try {
            con = getConnection();
// select username and password from the database
            String query = "Select  * from users where user_name = ? AND password = ? AND user_status = 1";
            ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count++;
            }
            //again we are checking for the existence of the account , if rs is 1, there is only one username that holds this password, therefore:
            if (count >= 1) {
                rs.first();
                flag = true;
                return flag;
            } else {
                flag = false;
                return flag;
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the login() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the login() method: " + e.getMessage());
            }
        }
        //User u = new User();
        flag = false;
        return flag;
    }

    //update customers info
    @Override
    public int updateCustomer(User user) {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        // int end = 0;
        // String userInput;
        try {
            conn = getConnection();

            // Get a statement from the connection
            ps = conn.prepareStatement("UPDATE users SET(user_id, fullName, user_name, email, password, user_status) values (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, user.getId());
            ps.setString(2, user.getFullName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setObject(5, user.getUserType());
            ps.setInt(6, user.getStatus());

            ps.executeUpdate();

            System.out.println("user has been updated.");

            return 1;
        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
            return 0;
        }
    }
}
