package DTO;

import java.util.Objects;

/**
 * @author micha
 */

public class User {

    private int Id;
    private String fullName;
    private String username;
    private String email;
    private String password;
    private UserType userType;
    private int status;
    private String date;

    public User(int Id, String fullName, String username, String email, String password, String userType, int status, String date) {
        this.Id = Id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = UserType.valueOf(userType);
        this.status = status;
        this.date = date;
    }

    public User(String fullName, String username, String email, String password) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(int Id, String fullName, String username, String email, String userType, int status, String date) {
        this.Id = Id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.userType = UserType.valueOf(userType);
        this.status = status;
        this.date = date;
    }

    public User() {
    }


    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.Id;
        hash = 53 * hash + Objects.hashCode(this.fullName);
        hash = 53 * hash + Objects.hashCode(this.username);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.password);
        hash = 53 * hash + Objects.hashCode(this.userType);
        hash = 53 * hash + this.status;
        hash = 53 * hash + Objects.hashCode(this.date);
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
        final User other = (User) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return this.userType == other.userType;
    }

    @Override
    public String toString() {
        return "User{" + "Id=" + Id + ", fullName=" + fullName + ", username=" + username + ", email=" + email + ", password=" + password + ", userType=" + userType + ", status=" + status + ", date=" + date + '}';
    }

}


