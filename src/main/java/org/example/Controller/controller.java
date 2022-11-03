package org.example.Controller;
import java.util.*;

import org.example.Repository.UserRepository;

public class controller {

    boolean isStore;
    boolean isUser;
    boolean isAdmin;

        // LOGIN SCREENS
        public void loginSystem() {
            int choice;
            Scanner inputScanner = new Scanner(System.in);
    
            System.out.println("\n\n================== LOGIN ===============" +
                    "\n1. Log in as admin" +
                    "\n2. Log in as user" +
                    "\n3. Log in as store" +
                    "\n4. Make new user" +
                    "\n5. Leave" +
                    "\n========================================");
    
            choice = inputScanner.nextInt();
    
            switch (choice) {
                case 1:
                    loginAdmin();      // Go to admin-screen
                case 2:
                    loginUser();  // Go to user-login screen
                case 3:
                    loginStore(); // Go to store-screen
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
            ArrayList<String> userNameArray = UserRepository.showUserName();

            if (userNameArray.isEmpty()){
                System.out.println("No users available");
            }
            else{
                for(String userName : userNameArray){
                    System.out.println(userName);
                }
            }

        }
        public void loginStore(){
            isAdmin = false;
            isUser = false;
            isStore = true;

        }
        public void newUser(){
            
        }
}
