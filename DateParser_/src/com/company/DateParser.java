package com.company;

import java.util.*;

public class DateParser {
    public static void main(String[] args) {
        System.out.print("Enter date in MM/DD/YYYY format");
        String scn = new Scanner(System.in).nextLine();

        String month = scn.substring(0, 2);
        String day = scn.substring(3, 5);
        String year = scn.substring(6, 10);

        System.out.println("Month: " + month + " Day: " + day + " Year: " + year);
    }
}
