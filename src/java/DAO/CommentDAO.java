package DAO;

import DTO.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author micha
 */
public class CommentDAO extends DAO implements CommentInterface {

    //public CommentDAO(String database) {
    //  super(database);
    //}

    public static void main(String[] args) {
        CommentDAO db = new CommentDAO();
        System.out.println("all comments = " + db.getPostComments(23));
    }

    @Override
    public List<Comment> getUserComments(int user_id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Comment> comments = new ArrayList();

        try {
            con = getConnection();
            String query = "Select * from comment where user_id =" + user_id;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Comment c = new Comment(rs.getInt("comment_id"),
                        rs.getString("comment_text"),
                        rs.getString("comment_link"),
                        rs.getInt("user_id"),
                        rs.getInt("post_id"));
                comments.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getUserComments()method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getUserComments() method: " + e.getMessage());
            }
        }
        return comments;
    }

    @Override
    public List<Comment> getPostComments(int post_id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Comment> comments = new ArrayList();

        try {
            con = getConnection();
            String query = "Select * from comment where post_id =" + post_id;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Comment c = new Comment(rs.getInt("comment_id"),
                        rs.getString("comment_text"),
                        rs.getString("comment_link"),
                        rs.getInt("user_id"),
                        rs.getInt("post_id"));
                comments.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getPostComments()method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getPostComments method: " + e.getMessage());
            }
        }
        return comments;
    }

    @Override
    public List<Comment> getAllComments() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Comment> comments = new ArrayList();
        try {
            con = getConnection();
            String query = "Select * from users";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Comment c = new Comment(rs.getInt("comment_id"),
                        rs.getString("comment_text"),
                        rs.getString("comment_link"),
                        rs.getInt("user_id"),
                        rs.getInt("post_id"));
                comments.add(c);

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllComments() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getAllComments() method: " + e.getMessage());
            }
        }
        return comments;
    }

    @Override
    public boolean MakeComment(Comment comments) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Comment> comm = new ArrayList();

        try {
            con = getConnection();
            ps = con.prepareStatement("insert into comment (comment_text,comment_link) values ( ?, ?)");
            ps.setString(1, comments.getComment_text());
            ps.setString(2, comments.getComment_link());
            System.out.println(" Comment Inserted");
            comm.add(comments);
        } catch (SQLException e) {
            System.out.println("Exception occured in the MakeComment() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the MakeComment() method: " + e.getMessage());
            }
        }
        // return flag;
        return false;
    }

    @Override
    public int countComments() {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs;
            //Creating the Statement object
            // Statement stmt = con.createStatement();
            //Statement st = con.prepareStatement(database);
            st = conn.createStatement();
            String strQuery = "SELECT COUNT( * )FROM comment";
            rs = st.executeQuery(strQuery);
            //Retrieving the result
            rs.next();
            int count = rs.getInt(1);

            //System.out.println("Total Row :" + count);
            rs.close();
            st.close();
            conn.close();
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }
}
