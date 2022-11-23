package org.example;


import org.example.Controller.Controller;
import org.example.Repository.*;


public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepoJSON("user.json");
        Controller controller = new Controller(userRepository);

        controller.loginSystem();
    }
}