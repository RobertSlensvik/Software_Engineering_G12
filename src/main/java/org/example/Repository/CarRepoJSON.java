package org.example.Repository;

import org.example.Model.Car;
import org.example.Model.User;
import org.example.Model.Store;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.io.File;
import java.util.Map;


public class CarRepoJSON {
    private String filename;
    HashMap<String, Car> carMap = new HashMap<>();

    public CarRepoJSON(String filename){
        this.filename = filename;

        readJSON(filename);
        wirteJSON(filename);
    }

    public void readJSON(String filename){
        Car[] carArray = new Car[0];
        HashMap<String, Car> returnMap = new HashMap<>();
        File file = new File(filename);
    }

    public void wirteJSON(String filename){
        ArrayList<Car> carArray = new ArrayList<>(carMap.values());
    }

    @Override
    public HashMap<String, Car> showAvalibleCars() {
        HashMap<String, Car> Cars = new HashMap<>();

        for (Map.Entry<String, Car> carSet : carMap.entrySet()){
            if (carSet.getValue().getRentersName() == null){
                Cars.put(carSet.getKey(), carSet.getValue());
            }
        }
        return Cars;
    }

    @Override
    public ArrayList<Car> showCar(String Car) {
        ArrayList<Car> Cars = new ArrayList<>();

        for (Map.Entry<String, Car> carSet : carMap.entrySet()){
            if (carSet.getValue().getBrand().equals(Car)){
                Cars.add(carSet.getValue());
            }
        }
        return Cars;
    }

    @Override
    public ArrayList<String> showCarName(boolean showAll, String carType){
        ArrayList<String> carNameArray = new ArrayList<>();

        for (Map.Entry<String, Car> carSet : carMap.entrySet()){
            if (showAll){
                carNameArray.add(carSet.getValue().getBrand());
            } else{
                if (carSet.getValue().getBrand().equals(carType)){
                    carNameArray.add(carSet.getValue().getBrand());
                }
                    if (carSet.getValue().getSold()){
                        if(carNameArray.contains(carSet.getValue().getBrand())){
                            carNameArray.remove(carSet.getValue().getBrand());
                        }
                    }
            }
        }
        return carNameArray;
    }
    
    @Override
    public HashMap<String, Car> showRentHistory(){
        HashMap<String, Car> rentHistory = new HashMap<>();

        for (Map.Entry<String, Car> carSet : carMap.entrySet()){
            if (carSet.getValue().getRentersName() != null){
                rentHistory.put(carSet.getKey(), carSet.getValue());
            }
        }
        return rentHistory;
    }

    @Override boolean isEmpty(){
        ArrayLitst<String> carNameArray = new ArrayList<>();

        for (Map.Entry<String, Car> carSet : carMap.entrySet()){
            if (carSet.getValue().getSold()){
                carNameArray.add(carSet.getValue().getBrand());
            }
        }
        return carNameArray.isEmpty();
    }

    @Override
    public Car getCar(String carKey){
        for (Map.Entry<String, Car> carSet : carMap.entrySet()){
            if (carSet.getKey().equals(carKey)){
                return carSet.getValue();
            }
        }
        return null;
    }

    @Override
    public void addCar(Car newCar){
        carMap.put(newCar.getBrand(), newCar);

        wirteJSON(filename);
    }

    @Override
    public void removeCar(String carKey){
        carMap.remove(carKey);

        wirteJSON(filename);
    }

    @override
    public void updateCar(String carKey, Car car){
        carMap.replace(carKey, car);
        carMap.remove(carKey);
        carMap.put(car.getBrand(), car);

        wirteJSON(filename);
    }

    @Override
    public void rentCar(Car car){
        car.setRented(true);

        wirteJSON(filename);
    }

    @Override
    public void returnCar(Car car){
        car.setRented(false);

        wirteJSON(filename);
    }
    
    @Override
    public void userRentCar(User user, Car car){
        car.setRentersName(user.getName());

        wirteJSON(filename);
    }

    @Override
    public void userReturnCar(User user, Car car){
        car.setRentersName(null);

        wirteJSON(filename);
    }

}
