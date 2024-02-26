package Controllers;

import Dao.UserDao;
import Model.User;
import Views.*;

public class mainController {
   @SuppressWarnings("static-access")
   public static void wel() {
      int choice = Welcome.welcomeScreen();
      if (choice == 1) {
         User data = Welcome.loginScreen();
         UserDao user = new UserDao();

         if (!user.userExists(data)) {
            System.out.println("User Does Not Exists .. Please Try Signing up");
            wel();
         } else {
            data = user.login(data);
            User.setId(data.getId());
            if (data.getRole().equals("admin")) {
               adminController.admin();
            } else if (data.getRole().equals("user")) {
               userController.user();
            }
         }
      } else if (choice == 2) {
         User data = Welcome.signupScreen();
         UserDao user = new UserDao();
         if(user.userExists(data))
         {
            System.out.println("User Already Exists...Please Login");
            wel();
         }
         else{
             if (user.createUser(data)) {
            System.out.print("Account as been Created...");
            System.out.println("Now Login..!");
            wel();
         } else {
            System.out.println("Something went Wrong try again");
            wel();
         }
         }
        
      }
   }
}
