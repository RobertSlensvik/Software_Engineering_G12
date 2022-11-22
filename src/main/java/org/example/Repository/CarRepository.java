package org.example.Repository;

import org.example.Model.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CarRepository {
    public Car getCar(String carKey);
    
    public boolean isEmpty();  
    public HashMap<String, Car> showAvalibleCars();
    ArrayList<Car> showCar(String Car);
    public ArrayList<String> showCarName();
    void rentCar(String car, String renter);
    void returnCar(String car);
    void addCar(Car car);
    void removeCar(String car);
    void updateCar(String car, String brand, String model, String year, String price, String color, String fuel, String seats, String doors, String transmission, String description);
    void userRentCar(String car, String renter);
    void userReturnCar(String car);
    public boolean carExists(String userInput);
}
