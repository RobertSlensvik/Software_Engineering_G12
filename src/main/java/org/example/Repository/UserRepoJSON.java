package org.example.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.User;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserRepoJSON implements UserRepository{
    private String fileName;

    HashMap<String, User> userMap = new HashMap<>();
    ObjectMapper objectMapper = new ObjectMapper();


    public UserRepoJSON(String fileName){
        this.fileName = fileName;

        readJSON(fileName);
        writeJSON(fileName);
    }

    public void readJSON(String fileName){
        User[] userArray = new User[0];
        HashMap<String, User> returnMap = new HashMap<>();
        File file = new File(fileName);
        
        try {
            userArray = objectMapper.readValue(file, User[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeJSON(String fileName){
        ArrayList<User> userArray = new ArrayList<>(userMap.values());

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), userArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String userKey) {
        return userMap.get(userKey);
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

        writeJSON(fileName);
        
    }

    @Override
    public void removeUser(User user) {
        userMap.remove(user.getName());
        
        writeJSON(fileName);
    }

    @Override
    public void depositMoney(User user, double money) {
        user.setMoney(user.getMoney() + money);
        
        writeJSON(fileName);
        
    }

    @Override
    public void withdrawMoney(User user, double money) {
        user.setMoney(user.getMoney() - money);
        
        writeJSON(fileName);
    }

    @Override
    public boolean userExists(String userName) {
        return userMap.containsKey(userName);
    }
}
