package org.example.Repository;

import org.example.Model.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserRepoJSON implements UserRepository{
    private String filename;

    HashMap<String, User> userMap = new HashMap<>();


    public UserRepoJSON(String filename){
        this.filename = filename;

        readJSON(filename);
        wirteJSON(filename);
    }

    public void readJSON(String filename){
        User[] userArray = new User[0];
        HashMap<String, User> returnMap = new HashMap<>();
        File file = new File(filename);
    }

    public void wirteJSON(String filename){
        ArrayList<User> userArray = new ArrayList<>(userMap.values());
    }

    @Override
    public User getUser(String userKey) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HashMap<String, User> showUser() {
        return new HashMap<>(userMap);
    }

    @Override
    public ArrayList<String> showUserName() {
        ArrayList userNamesArray = new ArrayList<>();

        for (Map.Entry<String, User> userSet : userMap.entrySet()){
            userNamesArray.add(userSet.getValue().getName());
        }
        return userNamesArray;
    }

    @Override
    public void addUser(User newUser) {
        userMap.put(newUser.getName(), newUser);
        
    }

    @Override
    public void removeUser(User user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void depositMoney(User user, double money) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void withdrawMoney(User user, double money) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean userExists(String userName) {
        // TODO Auto-generated method stub
        return false;
    }
}
