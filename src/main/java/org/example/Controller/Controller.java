package org.example.Controller;

import java.util.*;
import org.example.Model.User;
import org.example.Model.Store;
import org.example.Model.Car;
import org.example.Repository.StoreRepository;
import org.example.Repository.UserRepository;
import org.example.Repository.CarRepository;

public class Controller {
    //Reposetories
    private UserRepository userRepository;
    private StoreRepository storeRepository;
    private CarRepository carRepository;

    //Variables used to which user that is logged in
    private User currentUser;
    private Store currentStore;

    //Variables to get back to correct log in screen
    boolean isStore;
    boolean isUser;
    boolean isAdmin;



    public Controller(UserRepository userRepository, CarRepository carRepository, StoreRepository storeRepository){
        this.userRepository = userRepository;
        this.storeRepository = storeRepository;
        this.carRepository = carRepository;
    }



        public void loginSystem() {
            int choice;
            Scanner inputScanner = new Scanner(System.in);
    
            System.out.println("\n\n================== LOGIN PANEL ===============" +
                    "\n1. Log in as admin" +
                    "\n2. Log in as user" +
                    "\n3. Log in as car rental" +
                    "\n4. Make new user" +
                    "\n5. Leave" +
                    "\n========================================");
    
            choice = inputScanner.nextInt();
    
            switch (choice) {
                case 1:
                    loginAdmin();      // Go to admin-screen
                case 2:
                    loginUser();  // Go to user-login
                case 3:
                    loginCarRental(); // Go to rental screen
                case 4:
                    newUser();        // Make a new user
                case 5:
                    System.exit(0);             // Leave
            }
        }
    
    public void loginAdmin(){
        isStore = false;
        isUser = false;
        isAdmin = true;

        int choice;
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("\n\n================== ADMIN ===============" +
            "\n1. See cars" +
            "\n2. Update cars" +
            "\n3. Purchase History" +
            "\n4. See all Users" +
            "\n5. Log out"+
            "\n========================================");
        choice = inputScanner.nextInt();

        switch (choice){
            case 1:
                seeCars();
            case 2:
                updateCars();
            case 3:
                purchaseHistory();
            case 4:
                seeUser();
            case 5:
                loginSystem();
        }
    }
        public void loginUser(){
            System.out.println("\nWich User you want to log in:");
            ArrayList<String> userNameArray = userRepository.showUserName();

            if (userNameArray.isEmpty()){
                System.out.println("No users available");
            }
            else{
                for(String userName : userNameArray){
                    System.out.println(userName);
                }
            }
            String userInput;
            Scanner inputScanner = new Scanner(System.in);
            userInput = inputScanner.nextLine();

            if (userRepository.userExists(userInput)){
              user(userRepository.getUser(userInput));
            }
            else{
                System.out.println("\n That user does not exist");

                loginSystem();
            }

        }
        public void user(User user){
            currentUser = user;

            isAdmin = false;
            isStore = false;
            isUser = true;

            int choice;
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("\n ============ USER ==============" +
            "\n1. See Cars"+
            "\n2. Rent a car"+
            "\n3. Show rented cars"+
            "\n4. See balance"+
            "\n5. Add balance"+
            "\n6. Log out"+
            "\n======================================");
        choice = inputScanner.nextInt();

        switch(choice){
            case 1:
                seeCars();
            case 2:
                rentCar();
            case 3:
                showActiveRentals();
            case 4:
                endRentalTime();
            case 5:
                seeBalance();
            case 6:
                loginSystem();
        }
        
        }

        public void loginCarRental(){
            System.out.println("\n Which user are renting out?");
            ArrayList<String> rentalNamesArray =  userRepository.showUserName();

            if(rentalNamesArray.isEmpty()){
                System.out.println("\n No one registered.");
            }
            else{
                for(String userName : rentalNamesArray){
                    System.out.println(userName);
                }
                
            }
            String userinput;
            Scanner inputScanner = new Scanner(System.in);
            userinput = inputScanner.nextLine();
            

            if (userRepository.userExists(userinput)){
                store(currentStore);
            }
            else{
                System.out.println("\n That user does not exist");
                loginSystem();
            }
        }

        public void newUser(){
            String userName;
            double balance;

            Scanner inputScanner = new Scanner(System.in);
            System.out.println("\n Write your username");
            userName = inputScanner.nextLine();

            if (userRepository.userExists(userName)){
                System.out.println("\n That user already exists");
                loginSystem();
            }
            else{
                User user = new User(userName, 10000);
                userRepository.addUser(user);
                loginSystem();
            }
            
        }

        public void store(Store store){
            currentStore = store;

            isAdmin = false;
            isUser = false;
            isStore = true;

            int choice;
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("\n ============ CAR RENTAL ==============" +
                                "\n1. Rent out a car"+
                                "\n2. Show active rentals"+
                                "\n3. End rental time"+
                                "\n4. See balance"+
                                "\n5. Log out"+
                                "\n======================================");
            choice = inputScanner.nextInt();

            switch(choice){
                case 1:
                    updateCars();
                case 2:
                    showActiveRentals();
                case 3:
                    showRentHistory();
                case 4:
                    endRentalTime();
                case 5:
                    loginSystem();
            }
        }

        public void seeCars() {
            if(carRepository.isEmpty()){
                System.out.println("\n No cars available");
                goBack();
            }

            int choice;
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("\n ============ CARS ==============" +
                                "\n1. See all cars"+
                                "\n2. See rented cars"+
                                "\n3. Go back"+
                                "\n======================================");
            choice = inputScanner.nextInt();

            switch (choice){
                case 1:
                    showAvalibleCars();
                case 2:
                 purchaseHistory();   ;
                case 3:
                    goBack();
            }

        }

        public void showCarName(){ 
            System.out.println("\n All the cars");

            ArrayList<String> carHashMap = carRepository.showCarName();

            if (carHashMap.isEmpty()){
                System.out.println("\n No cars available");
            }
            else{
                for(String carName : carHashMap){
                    System.out.println(carName);
                }
            }
            goBack();
        }
     

        public void showAvalibleCars(){
            System.out.println("\n All the avalible cars");

            HashMap<String, Car> carHashMap = carRepository.showAvalibleCars();

            for(Map.Entry<String, Car> car : carHashMap.entrySet()){
                System.out.println(car.getKey() + " " + car.getValue());
            }
            seeCars();
        }



        public void updateCars(){
            int choice;
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("\n ============Update Cars==============" +
                                "\n1. Add a car"+
                                "\n2. Remove a car"+
                                "\n3. Go back"+
                                "\n======================================");
            choice = inputScanner.nextInt();

            switch (choice){
                case 1:
                    addCar();
                case 2:
                    removeCar();
                case 3:
                    goBack();
            }

        }

        public void addCar(){
            String carName;
            String rentersName;
            double price;
            String brand;
            String model;
            String color;
            String description;

            Scanner inputScanner = new Scanner(System.in);
            System.out.println("\n Write the name of the car");
            carName = inputScanner.nextLine();

            if (carRepository.carExists(carName)){
                System.out.println("\n That car already exists");
                updateCars();
            }
            else{

                System.out.println("\n Write the brand of the car");
                brand = inputScanner.nextLine();

                System.out.println("\n Write the model of the car");
                model = inputScanner.nextLine();

                System.out.println("\n Write the description of the car");
                description = inputScanner.nextLine();

                System.out.println("\n Write the color of the car");
                color = inputScanner.nextLine();


                System.out.println("\n Write the name of the renter");
                rentersName = inputScanner.nextLine();

                System.out.println("\n Write the price of the car");
                price = inputScanner.nextDouble();

                Car car = new Car(brand, model , description,price,rentersName,color);
                carRepository.addCar(car);
                updateCars();
            }
        }
            
        
        public void removeCar(){
            String carName;

            Scanner inputScanner = new Scanner(System.in);
            System.out.println("\n Write the name of the car");
            carName = inputScanner.nextLine();

            if (carRepository.carExists(carName)){
                carRepository.removeCar(carName);
                updateCars();
            }
            else{
                System.out.println("\n That car does not exist");
                updateCars();
            }
        }

        public void purchaseHistory() {
            System.out.println("\n Purchase history");

            HashMap<String, Car> carHashMap = carRepository.showAvalibleCars()();

            for(Map.Entry<String, Car> car : carHashMap.entrySet()){
                System.out.println(car.getKey() + " " + car.getValue());
            }
            seeCars();

        }

        public void goBack(){
            if (isUser){
                user(currentUser);
            }
            else if (isStore){
                store(currentStore);
            }
            else{loginAdmin();}
        }


        public Car rentCar(){
            System.out.println("\n Wich car do you want to rent out?");
            HashMap<String,Car> carNamesArray = carRepository.showAvalibleCars();

            if (carNamesArray.isEmpty()){
                System.out.println("\n No cars available");
            }
            else{
                for(Map.Entry<String, Car> car : carNamesArray.entrySet()){
                    System.out.println(car.getKey() + " " + car.getValue());
                    double balance = currentUser.getBalance()-car.getValue().getPrice();
                    Store store = new Store(car.getValue().getBrand(), car.getValue().getModel(), car.getValue().getDecsription(), car.getValue().getPrice(), car.getValue().getRentersName(),car.getValue().getColor(), currentUser.getName(), balance);
                    storeRepository.addCar(store);

                }
                removeCar();
                }

            String userInput;
            Scanner inputScanner = new Scanner(System.in);
            userInput = inputScanner.nextLine();

            if (carRepository.carExists(userInput)){
                return carRepository.getCar(userInput);
            }
            else{
                System.out.println("\n That car does not exist");
                goBack();
            }
            return null;
        }

       public void seeBalance(){
              if (isUser){
                System.out.println("\n Your balance is: " + currentUser.getBalance());
              }
              else if (isStore){
                System.out.println("\n Your balance is: " + currentStore.getBalance());
              }
              goBack();
       }

       public void showActiveRentals(){
            if (isUser){
                System.out.println("\n Your active rentals are: " + currentUser.getActiveRentals());
            }
            else if (isStore){
                System.out.println("\n Your active rentals are: " + currentStore.getActiveRentals());
            }
            goBack();
       }

       public void showRentHistory(){
            if (isUser){
                System.out.println("\n Your rent history is: " + currentUser.getRentHistory());
            }
            else if (isStore){
                System.out.println("\n Your rent history is: " + currentStore.getRentHistory());
            }
            goBack();
       }

       public String endRentalTime(){
            System.out.println("\n When did you end the rental?");
            String userInput;
            Scanner inputScanner = new Scanner(System.in);
            userInput = inputScanner.nextLine();
            return userInput;
       }

       public void seeUser(){
            System.out.println("\n All the users");

            HashMap<String, User> userHashMap = userRepository.showUser();

            for(Map.Entry<String, User> user : userHashMap.entrySet()){
                System.out.println(user.getKey() + " " + user.getValue());
            }
            goBack();
       }

}
