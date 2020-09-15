package com.company;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        int year = new Scanner(System.in).nextInt();
        boolean leapFlag = false;
        String[] dates;
        int sumdays = 365;

        if (year % 4 == 0) {
            leapFlag = true;
            sumdays = 366;
        }

        for (int month = 1; month <= 12; month++) {
            int days = 0;

            switch (month) {

                case 1, 3, 5, 7, 8, 10, 12:

                    days = 31;
                    break;

                case 4, 6, 9, 11:

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
                dates = new String[sumdays];

                for (int i = 0; i < dates.length; i++) {
                    dates[i] = date;
                }
                System.out.println(date);
            }
        }
    }
}
