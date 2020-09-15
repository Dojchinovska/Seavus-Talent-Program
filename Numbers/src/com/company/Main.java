package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        String input = new Scanner(System.in).nextLine();
        String[] result = input.split("\\s+");
        String[] result1;

        for (String x : result) {
            int sum = 0;
            int value = 0;

            switch (x) {
                case "one":
                    value = 1;
                    break;
                case "two":
                    value = 2;
                    break;

                case "three":
                    value = 3;
                    break;

                case "four":
                    value = 4;
                    break;

                case "five":
                    value = 5;
                    break;

                case "six":
                    value = 6;
                    break;


                case "seven":
                    value = 7;
                    break;

                case "eight":
                    value = 8;
                    break;

                case "nine":
                    value = 9;
                    break;

                case "zero":
                    value = 0;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            sum += value;

            System.out.print(sum);

        }

    }
}
