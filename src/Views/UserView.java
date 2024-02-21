package Views;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import Model.*;
import Util.*;

public class UserView {
    public static int userwelcome() {
        Scanner sc = scannerCon.connect();
        System.out.println();
        System.out.println("__________Welcome !!!__________");
        System.out.println("          1.Start Booking: ");
        System.out.println("          2.View All Hotels: ");
        System.out.println("          3.Exit: ");
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
        booking.setCheckIn(dateIn);
        System.out.print("Enter the CHECK OUT DATE(YYYY-MM-DD): ");
        String checkOut = sc.nextLine();
        LocalDate dateOut = LocalDate.parse(checkOut);
        booking.setCheckIn(dateOut);
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
        int days = period.getDays()+1;
        int noOfDaysStay = days;
        booking.setCity(city);
        booking.setNoofDays(noOfDaysStay);
      
        return booking;
    }
}
