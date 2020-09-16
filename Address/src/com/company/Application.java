package com.company;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Street: ");
        String street = sc.nextLine();
        System.out.println("Street number: ");
        Integer strNum = sc.nextInt();
        System.out.println("City: ");
        String city = sc.next();
        System.out.println("Zip code: ");
        Integer zipCode = sc.nextInt();

        try {
            Address adr = new Address(street, strNum, city, zipCode);
            System.out.println(adr);
        } catch (ZipCodeException e) {
            System.out.println(e.getMessage());
        }
    }
}
