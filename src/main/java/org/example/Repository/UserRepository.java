package org.example.Repository;

import org.example.Model.User;
import java.util.ArrayList;
import java.util.HashMap;


public interface UserRepository {
    User getUser(String userKey);
    HashMap<String, User> showUser();
    ArrayList<String> showUserName();
    void addUser(User newUser);
    void removeUser(User user);
    /*void depositMoney(User user, double money);
    void withdrawMoney(User user, double money);*/
    boolean userExists(String userName);
}