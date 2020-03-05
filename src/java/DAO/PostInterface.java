package DAO;
import DTO.Post;
import java.util.ArrayList;

/**
 *
 * @author micha
 */
public interface PostInterface {

    ArrayList<Post> getAllPosts();

    ArrayList<Post> getAllActivePosts();

    ArrayList<Post> getPostByUser(int user);

    ArrayList<Post> getPostsByCommunity(int community);

    ArrayList<Post> getPostByTitle(String title); //search methods, to search for posts

    ArrayList<Post> getPostById(int id);

    String addPostText(Post p);

    String addPostFile(Post p); //do we need this ?

}
