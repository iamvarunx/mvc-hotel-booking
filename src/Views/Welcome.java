package Views;

import Model.User;
import Util.scannerCon;

import java.util.*;


public class Welcome {

    public static int welcomeScreen() {
        System.out.println("        Welcome to Hotel Booking System");
        System.out.println("               1.Login");
        System.out.println("               2.Sign UP");
        System.out.println("               3.Exit");
        System.out.println("Enter Your choice: ");
        Scanner sc = scannerCon.connect();
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public static User loginScreen() {

        Scanner sc = scannerCon.connect();
        System.out.println("  Welcome to Sign Up page ");
        System.out.print("         Enter Email: ");
        String email = sc.nextLine();
        System.out.print("         Enter Passward: ");
        String passward = sc.nextLine();
        User data = new User(email, passward);
        return data;

    }

    public static User signupScreen() {
        Scanner sc = scannerCon.connect();
        System.out.println("  Welcome to Sign Up page ");
        System.out.print("         Enter Name: ");
        String name = sc.nextLine();
        System.out.print("         Enter Email: ");
        String email = sc.nextLine();
        System.out.print("         Enter Passward: ");
        String passward = sc.nextLine();
        System.out.print("         Enter Phone no: ");
        String phone = sc.nextLine();

        User data = new User(name, email, phone, passward);
        return data;
    }
}
