package org.example.Repository;

import org.example.Model.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CarRepository {

    boolean isEmpty();  
    HashMap<String, Car> showAvalibleCars();
    ArrayList<Car> showCar(String Car);
    ArrayList<String> showCarName(boolean showAll, String carType);
    void rentCar(String car, String renter);
    void returnCar(String car);
    void addCar(Car car);
    void removeCar(String car);
    void editCar(String car, String brand, String model, String year, String price, String color, String fuel, String seats, String doors, String transmission, String luggage, String airCondition, String gps, String sunRoof, String childSeat, String description);
    void updateCar(String car, String brand, String model, String year, String price, String color, String fuel, String seats, String doors, String transmission, String luggage, String airCondition, String gps, String sunRoof, String childSeat, String description);
    void userRentCar(String car, String renter);
    void userReturnCar(String car);


}
