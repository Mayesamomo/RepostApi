/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Objects;

/**
 * @author micha
 */
public class Comment {

    private int comment_id;
    private String comment_text;
    private String comment_link;
    private int user_id;
    private int post_id;

    public Comment(int comment_id, String comment_text, String comment_link, int user_id, int post_id) {
        this.comment_id = comment_id;
        this.comment_text = comment_text;
        this.comment_link = comment_link;
        this.user_id = user_id;
        this.post_id = post_id;
    }

    public Comment(int comment_id, String comment_text) {
        this.comment_id = comment_id;
        this.comment_text = comment_text;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public String getComment_link() {
        return comment_link;
    }

    public void setComment_link(String comment_link) {
        this.comment_link = comment_link;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.comment_id;
        hash = 13 * hash + Objects.hashCode(this.comment_text);
        hash = 13 * hash + Objects.hashCode(this.comment_link);
        hash = 13 * hash + this.user_id;
        hash = 13 * hash + this.post_id;
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
        final Comment other = (Comment) obj;
        if (this.comment_id != other.comment_id) {
            return false;
        }
        if (this.user_id != other.user_id) {
            return false;
        }
        if (this.post_id != other.post_id) {
            return false;
        }
        if (!Objects.equals(this.comment_text, other.comment_text)) {
            return false;
        }
        return Objects.equals(this.comment_link, other.comment_link);
    }

    @Override
    public String toString() {
        return "Comment{" + "comment_id=" + comment_id + ", comment_text=" + comment_text + ", comment_link=" + comment_link + ", user_id=" + user_id + ", post_id=" + post_id + '}';
    }


}
