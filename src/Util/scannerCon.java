package Util;

import java.util.Scanner;

public class scannerCon {
    private static Scanner sc=null;
    public static Scanner connect(){
        if(sc==null)
        return sc=new Scanner(System.in);
        else
        return sc;
    }
}
