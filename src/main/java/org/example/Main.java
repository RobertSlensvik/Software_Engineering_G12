package org.example;
import org.example.Controller.Controller;
import org.example.Repository.*;


public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepoJSON("user.json");
        CarRepository carRepository = new CarRepoJSON("car.json");
        StoreRepository storeRepository = new StoreRepoJSON("store.json");
        Controller controller = new Controller(userRepository, carRepository, storeRepository);

        controller.loginSystem();
    }
}