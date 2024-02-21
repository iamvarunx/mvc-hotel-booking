package Views;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import Connections.*;
import Model.*;

public class UserView {
    public static int userwelcome() {
        Scanner sc = scannerCon.connect();
        System.out.println();
        System.out.println("__________Welcome !!!__________");
        System.out.println("          1.Start Booking: ");
        System.out.println("          2.View All Hotels: ");
        System.out.println("          3.View Booked Details: ");
        System.out.println("          4.Cancel Booking: ");
        System.out.println("          5.View Booking History: ");
        System.out.println("          6.Exit: ");
        System.out.println("Enter Your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public static Booking bookigDetailsView() {
        Scanner sc = scannerCon.connect();
        Booking booking = new Booking();
        System.out.print("Enter the city name: ");
        String city = sc.nextLine().toLowerCase();
        System.out.print("Enter the CHECK IN DATE(YYYY-MM-DD): ");
        String checkIn = sc.nextLine();
        LocalDate dateIn = LocalDate.parse(checkIn);
        System.out.print("Enter the CHECK OUT DATE(YYYY-MM-DD): ");
        String checkOut = sc.nextLine();
        LocalDate dateOut = LocalDate.parse(checkOut);
        System.out.println();

        String checkInDay[] = checkIn.split("-");
        String checkOutDay[] = checkOut.split("-");
        int inyear = Integer.valueOf(checkInDay[0]);
        int inmonth = Integer.valueOf(checkInDay[1]);
        int inday = Integer.valueOf(checkInDay[2]);
        int outyear = Integer.valueOf(checkOutDay[0]);
        int outmonth = Integer.valueOf(checkOutDay[1]);
        int outday = Integer.valueOf(checkOutDay[2]);

        LocalDate start = LocalDate.of(inyear, inmonth, inday);
        LocalDate end = LocalDate.of(outyear, outmonth, outday);
        Period period = Period.between(start, end);
        int days = period.getDays() + 1;
        int noOfDaysStay = days;
        booking.setCheckIn(dateIn);
        booking.setCheckOut(dateOut);
        booking.setCity(city);
        booking.setNoofDays(noOfDaysStay);

        return booking;
    }

    public static void payment_screen(int perdayprice, int noOfDays, int total_price, int advanceAmount) {
        System.out.println("-------------------------------------------");
        System.out.println(" PER DAY PRICE                 =     RS." + perdayprice);
        System.out.println(" TOTAL NUMBER OF DAYS STAY     =     " + noOfDays);
        System.out.println("                                  -------------");
        System.out.println(" TOTAL AMOUNT                  =     RS." + total_price);
        System.out.println("                                  -------------");
        System.out.println(" ADVANCE AMOUNT TO BE PAID     =     RS." + advanceAmount);
        System.out.println("-------------------------------------------");

    }

    public static String payment_modeScreen() {
        Scanner sc = scannerCon.connect();
        System.out.println("CHOOSE THE MODE OF PAYMENT ");
        System.out.println("1.UPI");
        System.out.println("2.CREDIT CARD");
        System.out.println("3.DEBIT CARD");
        String mode = "";
        int choice = sc.nextInt();
        if (choice == 1)
            mode = "UPI";
        else if (choice == 2)
            mode = "CREDIT CARD";
        else if (choice == 3)
            mode = "DEBIT CARD";

        return mode;
    }

    public static void viewBookedDetails(List<List<String>> list) {
        if (list.size() == 0) {
            System.out.println("There is No Booked Rooms");
        } else {
            System.out.printf(
                    "------------------------------------------------------------------------------------------------------------------------------------------%n");
            System.out.printf("|%-10s|%-20s|%-20s|%-15s|%-11s|%-11s|%-6s|%-12s|%-12s|%-10s|%n",
                    "Booking_ID", "Hotel_address", "Hotel_city", "Room_type", "check_in", "check_out", "Rooms",
                    "payment_mode", "payment_date",
                    "Amount");
            System.out.printf(
                    "------------------------------------------------------------------------------------------------------------------------------------------%n");
            for (int i = 0; i < list.size(); i++) {

                System.out.printf("|%-10s|%-20s|%-20s|%-15s|%-11s|%-11s|%-6s|%-12s|%-12s|%-10s|%n",
                        list.get(i).get(0), list.get(i).get(1), list.get(i).get(2), list.get(i).get(3),
                        list.get(i).get(4),
                        list.get(i).get(5), list.get(i).get(6), list.get(i).get(7), list.get(i).get(8),
                        list.get(i).get(9));
            }
            System.out.printf(
                    "------------------------------------------------------------------------------------------------------------------------------------------%n");
        }
    }

    public static void viewAllPastBookedDetails(List<List<String>> list) {
        if (list.size() == 0) {
            System.out.println("There is No Booked Rooms");
        } else {
            System.out.printf(
                    "------------------------------------------------------------------------------------------------------------------------------------------%n");
            System.out.printf("|%-20s|%-20s|%-15s|%-11s|%-11s|%-6s|%-12s|%-12s|%-10s|%-10s|%n",
                    "Hotel_address", "Hotel_city", "Room_type", "check_in", "check_out", "Rooms",
                    "payment_mode", "payment_date",
                    "Amount", "status");
            System.out.printf(
                    "------------------------------------------------------------------------------------------------------------------------------------------%n");
            for (int i = 0; i < list.size(); i++) {

                System.out.printf("|%-20s|%-20s|%-15s|%-11s|%-11s|%-6s|%-12s|%-12s|%-10s|%-10s|%n",
                        list.get(i).get(0), list.get(i).get(1), list.get(i).get(2), list.get(i).get(3),
                        list.get(i).get(4),
                        list.get(i).get(5), list.get(i).get(6), list.get(i).get(7), list.get(i).get(8),
                        list.get(i).get(9));
            }
            System.out.printf(
                    "------------------------------------------------------------------------------------------------------------------------------------------%n");
        }
    }

    public static int viewToCancel(List<List<String>> list) {
        Scanner sc = scannerCon.connect();

        if (list.size() == 0) {
            System.out.println("There is No Booked Rooms");
        } else {
            System.out.printf(
                    "-----------------------------------------------------------------------------------------------------%n");
            System.out.printf("|%-10s|%-20s|%-20s|%-15s|%-11s|%-11s|%-6s|%n",
                    "Booking_ID", "Hotel_address", "Hotel_city", "Room_type", "check_in", "check_out", "Rooms");
            System.out.printf(
                    "-----------------------------------------------------------------------------------------------------%n");
            for (int i = 0; i < list.size(); i++) {

                System.out.printf("|%-10s|%-20s|%-20s|%-15s|%-11s|%-11s|%-6s|%n",
                        list.get(i).get(0), list.get(i).get(1), list.get(i).get(2), list.get(i).get(3),
                        list.get(i).get(4),
                        list.get(i).get(5), list.get(i).get(6));
            }
            System.out.printf(
                    "-----------------------------------------------------------------------------------------------------%n");

            System.out.println("Enter the Booking_ID to cancel :");
            int n = sc.nextInt();

            return n;
        }
        return 0;

    }
}
