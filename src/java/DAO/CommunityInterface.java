package DAO;
import DTO.Community;
import java.util.ArrayList;

/**
 *
 * @author micha
 */
public interface CommunityInterface {
    ArrayList<Community> getAllCommunitys();
    ArrayList<Community> getCommunityByUser(int user_id);
    ArrayList<Community> getCommunityByTitle(String title);
    String createCommunity(Community comm);
    String updateCommunity(Community comm);
}
