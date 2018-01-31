package com.itu.thombm.dynamicconnectivity;

public class Address {
    private final String street;
    private final int number;

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public static Address parse(String address) {
        String addressPattern = ".*\\w\\s\\d.*";

        if (address.matches(addressPattern)) {
            return new Address(address.substring(0, address.indexOf(" ")), Integer.valueOf(address.substring(address.indexOf(" ") + 1, address.length())));
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return street + " " + number;
    }
}
