import org.example.Model.Car;
import org.example.Repository.CarRepoJSON;
import org.example.Repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CarTest {
    CarRepository carRepository = new CarRepoJSON("carTest.json");

    Car newCar = new Car("Audi", "e-tron", "Electric", 
                        600, "so", "red");
    
    @Test
    public void isEmpty_return_true_if_car_repo_is_empty(){
        carRepository.removeCar(newCar.getBrand());
        Assertions.assertTrue(carRepository.isEmpty());
    }

    @Test
    public void isEmpty_return_false_if_car_repo_is_not_empty(){
        carRepository.addCar(newCar);
        Assertions.assertFalse(carRepository.isEmpty());
    }

    @Test
    public void carExists_return_true_if_car_exists(){
        carRepository.addCar(newCar);
        Assertions.assertTrue(carRepository.carExists(newCar.getBrand()));
    }

    @Test
    public void carExists_return_false_if_car_does_not_exist(){
        carRepository.removeCar(newCar.getBrand());
        Assertions.assertFalse(carRepository.carExists(newCar.getBrand()));
    }

    @Test
    public void showAvailableCars_return_if_showAvailableCars_is_not_empty(){
        carRepository.addCar(newCar);
        Assertions.assertNotNull(carRepository.showAvalibleCars());
    }

    @Test
    public void showAvailableCars_return_if_showAvalibleCars_is_empty(){
        carRepository.removeCar(newCar.getBrand());
        Assertions.assertTrue(carRepository.showAvalibleCars().isEmpty());

    }

    @Test
    public void showCar_return_rented_cars(){
        carRepository.addCar(newCar);

        Assertions.assertNotNull(carRepository.showCar());
    }

    @Test
    public void showCar_return_not_rented_cars(){
        carRepository.removeCar(newCar.getBrand());

        Assertions.assertTrue(carRepository.showCar().isEmpty());
    }

    @Test
    public void showCarName_return_car_name(){
        carRepository.addCar(newCar);

        Assertions.assertNotNull(carRepository.showCarName());
    }

    @Test
    public void showCarName_return_null_if_car_repo_is_empty(){
        carRepository.removeCar(newCar.getBrand());

        Assertions.assertTrue(carRepository.showCarName().isEmpty());
    }
}
