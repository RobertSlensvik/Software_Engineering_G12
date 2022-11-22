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

    // Variables to get cars
    private ArrayList<String> cars;
    private ArrayList<String> history;

    public Controller(UserRepository userRepository){
        this.userRepository = userRepository;
        this.storeRepository = storeRepository;
        this.carRepository = carRepository;
    }



        public void loginSystem() {
            int choice;
            Scanner inputScanner = new Scanner(System.in);
    
            System.out.println("\n\n================== LOGIN ===============" +
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
                    break;             // Leave
            }
        }
    
    public void loginAdmin(){
        isStore = false;
        isUser = false;
        isAdmin = true;

        int choice;
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("\n\n================== LOGIN ===============" +
            "\n1. See cars" +
            "\n2. Update cars" +
            "\n3. Purchase History" +
            "\n4. See all car rental" +
            "\n5. See all Users" +
            "\n6. Log out"+
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
                //carRentals();
            case 5:
                //seeUser();
            case 6:
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
            System.out.println("\n ============User==============" +
            "\n1. See Cars"+
            "\n2. Rent a car"+
            "\n3. Show rented cars"+
            "\n4. See balance"+
            "\n5. Add balance"+
            "\n6. Log out"+
            "\n======================================");
        choice = inputScanner.nextInt();
        
        }

        public void loginCarRental(){
            System.out.println("\n Which user are renting out?");
            ArrayList<String> rentalNamesArray = storeRepository.showRentalUser();

            if(rentalNamesArray.isEmpty()){
                System.out.println("\n No one registered.");
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
                User user = new User(userName, 0);
                userRepository.addUser(user);
                user(user);
            }
            goBack();
            
        }

        public void store(Store store){
            currentStore = store;

            isAdmin = false;
            isUser = false;
            isStore = true;

            int choice;
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("\n ============Car Rental==============" +
                                "\n1. See Cars"+        
                                "\n2. Rent out a car"+
                                "\n3. Show active rentals"+
                                "\n4. End rental time"+
                                "\n5. See balance"+
                                "\n6. Log out"+
                                "\n======================================");
            choice = inputScanner.nextInt();

            switch(choice){
                case 1:
                    seeCars();
                case 2:
                    rentCar();
                case 3:
                    //showActiveRentals();
                case 4:
                    //endRentalTime();
                case 5:
                    //seeBalance();
                case 6:
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
            System.out.println("\n ============Cars==============" +
                                "\n1. See all cars"+
                                "\n3. See rented cars"+
                                "\n4. Go back"+
                                "\n======================================");
            choice = inputScanner.nextInt();

            switch (choice){
                case 1:
                    showAllCars();
                case 2:
                    showRentedCars();
                case 3:
                    goBack();
            }

        }

        public void showAvalibleCars(){
            System.out.println("\n All cars available");

            HashMap<String, Car> carHashMap = carRepository.showAvalibleCars();

            for(Map.Entry<String, Car> car : carHashMap.entrySet()){
                System.out.println(carSet.getKey() + " " + carSet.getValue());
            }
            seeCars();
        }



        public void updateCars(){
            cars.add("Volvo");
            cars.add("BMW");
            cars.add("Ford");
            cars.add("Mazda");
            cars.remove(1);
            System.out.println("\n These are the cars.");

            for (int i = 0; i < cars.size(); i++) {
                System.out.println(cars.get(i));
            }


        }

        public void purchaseHistory() {

        for (int i = 0; i<history.size(); i++){
            System.out.println(history.get(i));
        }


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
            ArrayList<String> carNamesArray = carRepository.showCarName();

            if (carNamesArray.isEmpty()){
                System.out.println("\n No cars available");
            }
            else{
                for (String carName : carNamesArray){
                    System.out.println(carName);
                }
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


}
