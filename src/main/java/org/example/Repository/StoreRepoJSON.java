package org.example.Repository;

import org.example.Model.Store;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoreRepoJSON implements StoreRepository{

    private String fileName;
    HashMap<String, Store> storeMap = new HashMap<>();
    ObjectMapper objectMapper = new ObjectMapper();

    public StoreRepoJSON(String fileName){
        this.fileName = fileName;

        readJSON(fileName);
        writeJSON(fileName);
    }

    public void readJSON(String fileName){
        Store[] storeArray = new Store[0];
        HashMap<String, Store> retuMap = new HashMap<>();
        File file = new File(fileName);

        try {
            storeArray = objectMapper.readValue(file, Store[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeJSON(String fileName){
        ArrayList<Store> storeArray = new ArrayList<>(storeMap.values());

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), storeArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Store getStore(String storeKey) {
        return storeMap.get(storeKey);
    }

    @Override
    public HashMap<String, Store> showRental() {
        return new HashMap<>(storeMap);
    }

    @Override
    public ArrayList<String> showRentalUser() {
        ArrayList<String> storeNameArray = new ArrayList<>();

        for (Map.Entry<String, Store> storeSet : storeMap.entrySet()){
            storeNameArray.add(storeSet.getValue().getName());
        }
        return storeNameArray;
    }
    
}