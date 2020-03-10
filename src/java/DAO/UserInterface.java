package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DTO.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author micha
 */
public interface UserInterface {

    //
    public List<User> getUsers(int id);

    public ArrayList<User> getAllUsers();

    public boolean checkIfExist(String username, String email);

    // public String register(User user);
    public boolean register(User user);

    public boolean login(String username, String password);

    public int updateCustomer(User user);
}