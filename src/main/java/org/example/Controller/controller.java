package org.example.Controller;
import java.util.*;

public class controller {

    boolean isStore;
    boolean isUser;
    boolean isAdmin;

        // LOGIN SCREENS
        public void loginPanel() {
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
        }
        public void loginUser(){

        }
        public void loginStore(){

        }
        public void newUser(){
            
        }
}
