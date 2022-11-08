package org.example.Controller;
import java.util.*;

import org.example.Model.User;
import org.example.Repository.UserRepository;

public class Controller {
    //Reposetories
    private UserRepository userRepository;

    //Variables used to which user that is logged in
    private User currentUser;

    //Variables to get back to correct log in screen
    boolean isStore;
    boolean isUser;
    boolean isAdmin;

    public Controller(UserRepository userRepository){
        this.userRepository = userRepository;
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
                //seeCars();
            case 2:
                //updateCars();
            case 3:
                //purchaseHistory();
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
            isAdmin = false;
            isUser = false;
            isStore = true;

        }
        public void newUser(){
            
        }
}