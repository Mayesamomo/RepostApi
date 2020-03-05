package DTO;

import java.util.Objects;
/**
 *
 * @author micha
 */
public class Post {

    private int post_id;
    private String post_title;
    private String post_desc;
    private String post_date;
    private int user_id;
    private int community_id;
    private String url;
    private int post_status;

    public Post(int post_id, String post_title, String post_desc, String post_date, int user_id, int community_id, String url, int post_status) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.post_desc = post_desc;
        this.post_date = post_date;
        this.user_id = user_id;
        this.community_id = community_id;
        this.url = url;
        this.post_status = post_status;
    }

    public Post() {
        
    }

    public int getPost_id() {
        return post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public String getPost_desc() {
        return post_desc;
    }

    public String getPost_date() {
        return post_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getCommunity_id() {
        return community_id;
    }

    public String getUrl() {
        return url;
    }

    public int getPost_status() {
        return post_status;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public void setPost_desc(String post_desc) {
        this.post_desc = post_desc;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPost_status(int post_status) {
        this.post_status = post_status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.post_id;
        hash = 97 * hash + Objects.hashCode(this.post_title);
        hash = 97 * hash + Objects.hashCode(this.post_desc);
        hash = 97 * hash + Objects.hashCode(this.post_date);
        hash = 97 * hash + this.user_id;
        hash = 97 * hash + this.community_id;
        hash = 97 * hash + Objects.hashCode(this.url);
        hash = 97 * hash + this.post_status;
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
        final Post other = (Post) obj;
        if (this.post_id != other.post_id) {
            return false;
        }
        if (this.user_id != other.user_id) {
            return false;
        }
        if (this.community_id != other.community_id) {
            return false;
        }
        if (this.post_status != other.post_status) {
            return false;
        }
        if (!Objects.equals(this.post_title, other.post_title)) {
            return false;
        }
        if (!Objects.equals(this.post_desc, other.post_desc)) {
            return false;
        }
        if (!Objects.equals(this.post_date, other.post_date)) {
            return false;
        }
        return Objects.equals(this.url, other.url);
    }

    @Override
    public String toString() {
        return "Post{" + "post_id=" + post_id + ", post_title=" + post_title + ", post_desc=" + post_desc + ", post_date=" + post_date + ", user_id=" + user_id + ", community_id=" + community_id + ", url=" + url + ", post_status=" + post_status + '}';
    }

    
}
