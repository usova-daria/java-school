package com.javaschool.util;

import com.javaschool.entity.address.Address;

public class AddressUtil {

    private AddressUtil() {}

    public static String addressToString(Address address) {
        if (address == null) return "NA";

        String country = address.getCountry().getName();
        String town = address.getTown().getName();
        String postalCode = address.getPostalCode();

        String street = address.getStreet();
        String building = address.getBuilding();
        String apartment = address.getApartment();

        return addressToString(country, town, postalCode, street, building, apartment);
    }

    private static String addressToString(String country, String town, String postalCode, String street,
                                         String building, String apartment) {
        return  String.format("%s %s %s %n%s, %s %s",
                building, street, apartmentToString(apartment),
                town, country, postalCode);
    }

    private static String apartmentToString(String apartment) {
        if (apartment == null || apartment.trim().isEmpty()) {
            return "";
        }

        return "APT " + apartment;
    }

}
