package org.example.Repository;

import org.example.Model.Store;
import java.util.ArrayList;
import java.util.HashMap;

public class storeRapository {
    Store getStore(String storeKey);
    HashMap<String, Store> showStores();
    ArrayList<String> showStoreNames();
}
