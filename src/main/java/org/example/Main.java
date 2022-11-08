package org.example;

import org.example.Controller.Controller;
import org.example.Model.*;
import org.example.Repository.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        UserRepository userRepository = new UserRepoJSON("user.json");
        Controller controller = new Controller(userRepository);

        controller.loginSystem();
    }
}