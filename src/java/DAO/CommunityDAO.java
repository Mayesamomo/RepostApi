package DAO;

import DTO.Community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author micha
 */
public class CommunityDAO extends DAO implements CommunityInterface {

    // public CommunityDAO(String database) {
    //  super(database);
    // }

    @Override
    public ArrayList<Community> getAllCommunitys() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Community> community = new ArrayList();
        try {
            con = getConnection();
            String query = "Select * from community where community_status =1";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Community comm = new Community(
                        rs.getInt("community_id"),
                        rs.getString("community_name"),
                        rs.getString("community_desc"),
                        rs.getInt("community_status"),
                        rs.getInt("user_id")
                );
                community.add(comm);
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
                System.out.println("Exception occured in the finally section of the   method: " + e.getMessage());
            }
        }
        return community;
    }

    @Override
    public ArrayList<Community> getCommunityByUser(int user_id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Community> community = new ArrayList();
        try {
            con = getConnection();
            String query = "Select * from community where user_id =?";
            ps = con.prepareStatement(query);
            ps.setInt(1, user_id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Community comm = new Community(
                        rs.getInt("community_id"),
                        rs.getString("community_name"),
                        rs.getString("community_desc"),
                        rs.getInt("community_status"),
                        rs.getInt("user_id")
                );
                community.add(comm);
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
                System.out.println("Exception occured in the finally section of the   method: " + e.getMessage());
            }
        }
        return community;
    }

    @Override
    public ArrayList<Community> getCommunityByTitle(String title) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Community> community = new ArrayList();

        try {
            con = getConnection();
            String query = "Select * from community where community_name =?";
            ps = con.prepareStatement(query);
            ps.setString(1, title);
            rs = ps.executeQuery();

            while (rs.next()) {
                Community comm = new Community(
                        rs.getInt("community_id"),
                        rs.getString("community_name"),
                        rs.getString("community_desc"),
                        rs.getInt("community_status"),
                        rs.getInt("user_id")
                );
                community.add(comm);
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
                System.out.println("Exception occured in the finally section of the   method: " + e.getMessage());
            }
        }
        return community;
    }

    @Override
    public String createCommunity(Community comm) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String output = "wont go to try";
        try {
            conn = getConnection();
            // Can also do:
            String query = "INSERT INTO community(user_id,community_name, community_desc) VALUES (?,?,?);";
            ps = conn.prepareStatement(query);
            ps.setInt(1, comm.getUser_id());
            ps.setString(2, comm.getCommunity_name());
            ps.setString(3, comm.getCommunity_desc());
            ps.executeUpdate();
            output = "comm added";

        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            // Close the result set, statement and the connection
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception occurred when attempting to close the PreparedStatement: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Exception occurred when attempting to close the Connection: " + ex.getMessage());
                }
            }
        }

        return output;
    }

    @Override
    public String updateCommunity(Community comm) {
        Connection conn = null;
        PreparedStatement ps = null;
        String output = "wont go to try";
        try {
            conn = getConnection();
            // Can also do:
            String query = "UPDATE community SET community_name=? , community_desc=? WHERE community_id=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, comm.getCommunity_name());
            ps.setString(2, comm.getCommunity_desc());
            ps.setInt(3, comm.getCommunity_id());
            ps.executeUpdate();
            output = "comm updated";

        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            // Close the result set, statement and the connection
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception occurred when attempting to close the PreparedStatement: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Exception occurred when attempting to close the Connection: " + ex.getMessage());
                }
            }
        }

        return output;
    }

}
