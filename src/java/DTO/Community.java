package DTO;
import java.util.Objects;
/**
 *
 * @author micha
 */
public class Community {
 private int community_id;
 private String community_name;
 private String community_desc;
 private int community_status;
 private int user_id;
 private int memCount;

    public Community(int community_id, String community_name, String community_desc, int community_status, int user_id, int memCount) {
        this.community_id = community_id;
        this.community_name = community_name;
        this.community_desc = community_desc;
        this.community_status = community_status;
        this.user_id = user_id;
        this.memCount = memCount;
    }

    public Community(String community_name, String community_desc, int user_id) {
        this.community_name = community_name;
        this.community_desc = community_desc;
        this.user_id = user_id;
    }

    public Community(int community_id, String community_name, String community_desc, int community_status, int user_id) {
        this.community_id = community_id;
        this.community_name = community_name;
        this.community_desc = community_desc;
        this.community_status = community_status;
        this.user_id = user_id;
    }

   

    
    public int getCommunity_id() {
        return community_id;
    }

    public String getCommunity_name() {
        return community_name;
    }

    public String getCommunity_desc() {
        return community_desc;
    }

    public int getCommunity_status() {
        return community_status;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getMemCount() {
        return memCount;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    public void setCommunity_desc(String community_desc) {
        this.community_desc = community_desc;
    }

    public void setCommunity_status(int community_status) {
        this.community_status = community_status;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setMemCount(int memCount) {
        this.memCount = memCount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.community_id;
        hash = 97 * hash + Objects.hashCode(this.community_name);
        hash = 97 * hash + Objects.hashCode(this.community_desc);
        hash = 97 * hash + this.community_status;
        hash = 97 * hash + this.user_id;
        hash = 97 * hash + this.memCount;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Community other = (Community) obj;
        if (this.community_id != other.community_id) {
            return false;
        }
        if (this.community_status != other.community_status) {
            return false;
        }
        if (this.user_id != other.user_id) {
            return false;
        }
        if (this.memCount != other.memCount) {
            return false;
        }
        if (!Objects.equals(this.community_name, other.community_name)) {
            return false;
        }
        return Objects.equals(this.community_desc, other.community_desc);
    }

    @Override
    public String toString() {
        return "Community{" + "community_id=" + community_id + ", community_name=" + community_name + ", community_desc=" + community_desc + ", community_status=" + community_status + ", user_id=" + user_id + ", memCount=" + memCount + '}';
    }
 
 
 
 
                            
}
