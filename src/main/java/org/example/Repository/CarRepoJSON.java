package org.example.Repository;

import org.example.Model.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.Map;


public class CarRepoJSON implements CarRepository {
    private String filename;
    HashMap<String, Car> carMap = new HashMap<>();
    ObjectMapper objectMapper = new ObjectMapper();

    public CarRepoJSON(String filename){
        this.filename = filename;

        readJSON(filename);
        wirteJSON(filename);
    }

    public void readJSON(String filename){
        Car[] carArray = new Car[0];
        File file = new File(filename);

        try {
            carArray = objectMapper.readValue(file, Car[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wirteJSON(String filename){
        ArrayList<Car> carArray = new ArrayList<>(carMap.values());

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), carArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

   /*@Override
    public ArrayList<String> showCarName(boolean showAll, String carType){
        ArrayList<String> carNameArray = new ArrayList<>();

        for (Map.Entry<String, Car> carSet : carMap.entrySet()){
            if (showAll){
                carNameArray.add(carSet.getValue().getBrand());
            } else{
                if (carSet.getValue().getBrand().equals(carType)){
                    carNameArray.add(carSet.getValue().getBrand());
                }
                    if (carSet.getValue().getBrand() != null){
                        if(carNameArray.contains(carSet.getValue().getBrand())){
                            carNameArray.remove(carSet.getValue().getBrand());
                        }
                    }
            }
        }
        return carNameArray;
    }*/
    
    /*@Override
    public HashMap<String, Car> showRentHistory(){
        HashMap<String, Car> rentHistory = new HashMap<>();

        for (Map.Entry<String, Car> carSet : carMap.entrySet()){
            if (carSet.getValue().getRentersName() != null){
                rentHistory.put(carSet.getKey(), carSet.getValue());
            }
        }
        return rentHistory;
    }*/

    @Override
    public
    boolean isEmpty(){
        ArrayList<String> carNameArray = new ArrayList<>();

        for (Map.Entry<String, Car> carSet : carMap.entrySet()){
            if (carSet.getValue().getBrand() != null){
                carNameArray.add(carSet.getValue().getBrand());
            }
        }
        return carNameArray.isEmpty();
    }

    @Override
    public Car getCar(String carKey){
        return carMap.get(carKey);
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


    @Override
    public void rentCar(String car, String renter) {
        for (Map.Entry<String, Car> carSet : carMap.entrySet()){
            if (carSet.getValue().getBrand().equals(car)){
                carSet.getValue().setRentersName(renter);
            }
        }
        wirteJSON(filename);
        
    }


    @Override
    public void userRentCar(String car, String renter) {
        for (Map.Entry<String, Car> carSet : carMap.entrySet()){
            if (carSet.getValue().getBrand().equals(car)){
                carSet.getValue().setRentersName(renter);
            }
        }
        wirteJSON(filename);
        
        
    }

    @Override
    public void userReturnCar(String car) {
        for (Map.Entry<String, Car> carSet : carMap.entrySet()){
            if (carSet.getValue().getBrand().equals(car)){
                carSet.getValue().setRentersName(null);
            }
        }
        wirteJSON(filename);
        
        
    }

    @Override
    public boolean carExists(String userInput) {
        for (Map.Entry<String, Car> carSet : carMap.entrySet()){
            if (carSet.getValue().getBrand().equals(userInput)){
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<String> showCarName() {
        ArrayList<String> carNameArray = new ArrayList<>();

        for (Map.Entry<String, Car> carSet : carMap.entrySet()){
            if (carSet.getValue().getBrand() != null){
                carNameArray.add(carSet.getValue().getBrand());
            }
        }
        return carNameArray;
    }

    @Override
    public void updateCar(String car, String brand, String model, Double price, String description) {
        for (Map.Entry<String, Car> carSet : carMap.entrySet()){
            if (carSet.getValue().getBrand().equals(car)){
                carSet.getValue().setBrand(brand);
                carSet.getValue().setModel(model);
                carSet.getValue().setPrice(price);
                carSet.getValue().setDescription(description);
            }
        }
        wirteJSON(filename);
        
    }

}
