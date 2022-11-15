package org.example.Repository;

import org.example.Model.Store;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoreRepoJSON implements StoreRepository{

    private String fileName;
    HashMap<String, Store> storeMap = new HashMap<>();

    public StoreRepoJSON(String fileName){
        this.fileName = fileName;

        readJSON(fileName);
        writeJSON(fileName);
    }

    public void readJSON(String fileName){
        Store[] storeArray = new Store[0];
        HashMap<String, Store> retuMap = new HashMap<>();
        File file = new File(fileName);
    }

    public void writeJSON(String fileName){
        ArrayList<Store> storeArray = new ArrayList<>(storeMap.values());
    }





    @Override
    public Store getStore(String storeKey) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HashMap<String, Store> showRental() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<String> showRentalUser() {
        // TODO Auto-generated method stub
        return null;
    }
    
}