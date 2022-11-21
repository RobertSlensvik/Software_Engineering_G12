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

    @override
    public ArrayList<String> showCarName(boolean showAll, String carType){
        
    }
    

}
