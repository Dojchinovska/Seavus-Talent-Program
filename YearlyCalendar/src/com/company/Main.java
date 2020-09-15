package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int year = new Scanner(System.in).nextInt();
        boolean leapFlag;
        String[] dates;
        int sumdays = 0;

        if (year % 4 == 0) {
            leapFlag = true;
            dates = new String[366];
            sumdays = 366;
        } else {
            leapFlag = false;
            dates = new String[365];
            sumdays = 365;
        }

        for (int month = 1; month <= 12; month++) {
            int days = 0;
            switch (month) {

                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days = 30;
                    break;

                case 2:
                    if (leapFlag) {
                        days = 29;
                    } else {
                        days = 28;
                    }
                    break;

            }

            for (int day = 1; day <= days; day++) {
                String date = day + "-" + month + "-" + year;

                for (int i = 0; i < sumdays; i++) {
                    dates[i] = date;
                }

                System.out.println(date);
            }
        }
    }
}
