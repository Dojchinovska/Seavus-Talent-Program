package com.company;

public class Address {
    private String street;
    private Integer strNum;
    private String city;
    private Integer zipCode;

    public Address() {
    }

    public Address(String street, int strNum, String city, Integer zipCode) throws ZipCodeException {
        this.street = street;
        this.strNum = strNum;
        this.city = city;

        if (isZipCodeValid(zipCode)) {
            this.zipCode = zipCode;
        } else throw new ZipCodeException("The zip code is invalid");
    }

    @Override
    public String toString() {
        return "Address: " +
                "Street = '" + street + '\'' +
                ", Street number = " + strNum +
                ", City = '" + city + '\'' +
                ", ZipCode = " + zipCode +
                ' ';
    }

    public boolean isZipCodeValid(int val) {
        int numDigits = String.valueOf(val).length();
        return numDigits == 5 || numDigits == 9 ? true : false;
    }


}
