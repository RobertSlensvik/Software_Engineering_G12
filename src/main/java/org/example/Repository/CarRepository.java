package org.example.Repository;

import org.example.Model.*;
import java.util.ArrayList;
import java.util.HashMap;

public interface CarRepository {
    Car getCar(String carKey);

    boolean isEmpty();  
    HashMap<String, Car> showAvalibleCars();
    HashMap<String, Car> showCar();
    ArrayList<String> showCarName();
    void rentCar(String car, String renter);
    void addCar(Car car);
    void removeCar(String car);
    void updateCar(String car, String brand, String model, Double price, String description);
    void userRentCar(String car, String renter);
    void userReturnCar(String car);
    boolean carExists(String userInput);
}
