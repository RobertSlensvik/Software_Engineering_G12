package org.example.Controller;
import java.util.*;

public class controller {

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
                    adminPanel();      // Go to admin-screen
                case 2:
                    loginUserPanel();  // Go to user-login screen
                case 3:
                    loginStorePanel(); // Go to store-screen
                case 4:
                    makeUser();        // Make a new user
                case 5:
                    break;             // Leave
            }
        }
    
}
