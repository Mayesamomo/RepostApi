package DAO;
import DTO.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author micha
 */
public class PostDAO extends DAO implements PostInterface {
private static PostDAO ourInstance = new PostDAO();
 public static PostDAO getInstance() {
        return ourInstance;
    }
    //public PostDAO(String database) {
       // super(database);
   // }

    @Override
    public ArrayList<Post> getAllPosts() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Post> posts = new ArrayList();

        try {
            conn = getConnection();
            String query = "SELECT * FROM post";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            // Loop through the result set
            while (rs.next()) {
                Post p = new Post();
                // Get the pieces of a customer from the resultset
                p.setPost_id(rs.getInt("post_id"));
                p.setPost_title(rs.getString("post_title"));
                p.setPost_desc(rs.getString("post_description"));
                p.setPost_date(rs.getString("post_date"));
                p.setUser_id(rs.getInt("user_id"));
                p.setUser_id(rs.getInt("post_status"));
                p.setCommunity_id(rs.getInt("community"));
                posts.add(p);

            }
        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            // Close the result set, statement and the connection
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Exception occurred when attempting to close ResultSet: " + ex.getMessage());
                }
            }
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
        return posts;
    }
//method returns all post that are active only for users to see.

    @Override
    public ArrayList<Post> getAllActivePosts() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Post> posts = new ArrayList();

        try {
            conn = getConnection();
            String query = "SELECT * FROM post WHERE post_status=1";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            // Loop through the result set
            while (rs.next()) {
                Post p = new Post();
                // Get the pieces of a customer from the resultset
                p.setPost_id(rs.getInt("post_id"));
                p.setPost_title(rs.getString("post_title"));
                p.setPost_desc(rs.getString("post_description"));
                p.setPost_date(rs.getString("post_date"));
                p.setUser_id(rs.getInt("user_id"));
                p.setPost_status(rs.getInt("post_status"));
                p.setCommunity_id(rs.getInt("community"));
                posts.add(p);

            }
        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            // Close the result set, statement and the connection
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Exception occurred when attempting to close ResultSet: " + ex.getMessage());
                }
            }
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
        return posts;
    }

    @Override
    public ArrayList<Post> getPostByUser(int user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Post> posts = new ArrayList();

        try {
            conn = getConnection();
            String query = "SELECT * FROM post where user_id=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, user);
            rs = ps.executeQuery();

            // Loop through the result set
            while (rs.next()) {
                Post p = new Post();
                // Get the pieces of a customer from the resultset
                p.setPost_id(rs.getInt("post_id"));
                p.setPost_title(rs.getString("post_title"));
                p.setPost_desc(rs.getString("post_description"));
                p.setPost_date(rs.getString("post_date"));
                p.setUser_id(rs.getInt("user_id"));
                p.setPost_status(rs.getInt("post_status"));
                p.setCommunity_id(rs.getInt("community"));
                posts.add(p);

            }
        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            // Close the result set, statement and the connection
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Exception occurred when attempting to close ResultSet: " + ex.getMessage());
                }
            }
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
        return posts;
    }

    @Override
    public ArrayList<Post> getPostsByCommunity(int community) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Post> posts = new ArrayList();

        try {
            conn = getConnection();
            String query = "SELECT * FROM post where community=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, community);
            rs = ps.executeQuery();

            // Loop through the result set
            while (rs.next()) {
                Post p = new Post();
                // Get the pieces of a customer from the resultset
                p.setPost_id(rs.getInt("post_id"));
                p.setPost_title(rs.getString("post_title"));
                p.setPost_desc(rs.getString("post_description"));
                p.setPost_date(rs.getString("post_date"));
                p.setUser_id(rs.getInt("user_id"));
                p.setPost_status(rs.getInt("post_status"));
                p.setCommunity_id(rs.getInt("community"));
                posts.add(p);

            }
        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            // Close the result set, statement and the connection
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Exception occurred when attempting to close ResultSet: " + ex.getMessage());
                }
            }
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
        return posts;
    }

    @Override
    public ArrayList<Post> getPostByTitle(String title) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Post> posts = new ArrayList();

        try {
            conn = getConnection();
            String query = "SELECT * FROM post where post_title=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, title);
            rs = ps.executeQuery();

            // Loop through the result set
            while (rs.next()) {
                Post p = new Post();
                // Get the pieces of a customer from the resultset
                p.setPost_id(rs.getInt("post_id"));
                p.setPost_title(rs.getString("post_title"));
                p.setPost_desc(rs.getString("post_description"));
                p.setPost_date(rs.getString("post_date"));
                p.setUser_id(rs.getInt("user_id"));
                p.setPost_status(rs.getInt("post_status"));
                p.setCommunity_id(rs.getInt("community"));
                posts.add(p);

            }
        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            // Close the result set, statement and the connection
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Exception occurred when attempting to close ResultSet: " + ex.getMessage());
                }
            }
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
        return posts;
    }

    @Override
    public ArrayList<Post> getPostById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Post> posts = new ArrayList();

        try {
            conn = getConnection();
            String query = "SELECT * FROM post where post_id=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            // Loop through the result set
            while (rs.next()) {
                Post p = new Post();
                // Get the pieces of a customer from the resultset
                p.setPost_id(rs.getInt("post_id"));
                p.setPost_title(rs.getString("post_title"));
                p.setPost_desc(rs.getString("post_description"));
                p.setPost_date(rs.getString("post_date"));
                p.setUser_id(rs.getInt("user_id"));
                p.setPost_status(rs.getInt("post_status"));
                p.setCommunity_id(rs.getInt("community"));
                posts.add(p);

            }
        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            // Close the result set, statement and the connection
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Exception occurred when attempting to close ResultSet: " + ex.getMessage());
                }
            }
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
        return posts;
    }

    @Override
    public String addPostText(Post p) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String output = "wont go to try";

        // Create variables used to interact with database 
        // We need them created here so we can close them in the finally block
        try {
            conn = getConnection();

            // Can also do:
            ps = conn.prepareStatement("INSERT INTO post(post_title, post_description,user_id, community,post_status) "
                    + "VALUES (?,?,?,?,?);");

            // Get a statement from the connection
            ps.setString(1, p.getPost_title());
            ps.setString(2, p.getPost_desc());
            ps.setInt(3, p.getUser_id());
            
            ps.setInt(4, p.getCommunity_id());

            // Execute the query
            int n = ps.executeUpdate();
            output = "postAdded";

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

    /**
     *
     * @param p
     * @return
     */
    @Override
    public String addPost(Post p) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String output = "";

        // Create variables used to interact with database 
        // We need them created here so we can close them in the finally block
        try {
            conn = getConnection();

            // Can also do:
            ps = conn.prepareStatement("INSERT INTO post(post_title, post_description,filePath,user_id, community) "
                    + "VALUES (?,?,?,?,? );");

            // Get a statement from the connection
            ps.setString(1, p.getPost_title());
            ps.setString(2, p.getPost_desc());
            ps.setString(3, p.getUrl());
            ps.setInt(4, p.getUser_id());
            ps.setInt(5, p.getPost_status());
            ps.setInt(6, p.getCommunity_id());

            // Execute the query
            int n = ps.executeUpdate();
            output = "postAdded";

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
