/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import DTO.User;
import REST.UserResource;

/**
 *
 * @author micha
 */
public class Test {

    public static void main(String[] args) {
        UserResource rs = new UserResource();
        User us = new User("my name","niki","niki@gmail.com","password");
        String reg = "{\n"
                + "    \"email\": \"anime@gmail.com\",\n"
                + "    \"fullName\": \"Modric bill\",\n"
                + "    \"password\": \"password\",\n"
                + "    \"user_name\": \"mod\"\n"
                + "}";
                
        rs.Login(us);
    }

}
