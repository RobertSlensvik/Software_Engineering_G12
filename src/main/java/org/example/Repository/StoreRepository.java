package org.example.Repository;

import org.example.Model.Store;
import java.util.ArrayList;
import java.util.HashMap;

public interface StoreRepository {
    Store getStore(String storeKey);
    HashMap<String, Store> showRental();
    ArrayList<String> showRentalUser();
}