import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.example.Model.Store;
import org.example.Repository.StoreRepoJSON;
import org.example.Repository.StoreRepository;

public class Store_test {
    StoreRepository storeRepository = new StoreRepoJSON("storeTest.json");

    Store newStore = new Store("Audi", "1999", "Big car", 900, "Robert", "Black", "Mohammed", 1000);

    @Test
    public void getStore_return_store_if_store_exists(){
        storeRepository.addStore(newStore);
        Assertions.assertNotNull(storeRepository.getStore(newStore.getName()));
    }

    @Test
    public void getStore_return_null_if_store_does_not_exist(){
        storeRepository.removeStore(newStore.getName());
        Assertions.assertNull(storeRepository.getStore("Robert"));
    }

    
}
