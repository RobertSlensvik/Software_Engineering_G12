package org.example;

import javax.swing.ProgressMonitorInputStream;

import org.example.Controller.Controller;
import org.example.Repository.*;


public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepoJSON("user.json");
        Controller controller = new Controller(userRepository);
        StoreRepository storeRepository = new StoreRepoJSON("store.json");
        CarRepository carRepository = new CarRepoJSON("car.json");

        controller.loginSystem();
    }
}