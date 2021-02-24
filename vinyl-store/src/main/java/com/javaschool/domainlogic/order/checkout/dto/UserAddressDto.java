package com.javaschool.domainlogic.order.checkout.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Daria Usova
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressDto {

    /**
     * Address id
     */
    private Long id;

    /**
     * Street
     */
    private String street;

    /**
     * Building
     */
    private String building;

    /**
     * Apartment
     */
    private String apartment;

    /**
     * Country id
     */
    private Integer countryId;

    /**
     * Country name
     */
    private String countryName;

    /**
     * Town id
     */
    private Integer townId;

    /**
     * Town name
     */
    private String townName;

    /**
     * Postal code
     */
    private String postalCode;

    @Override
    public String toString() {
        String apt;
        if (apartment == null || apartment.trim().isEmpty()) {
            apt = "";
        } else {
            apt = "APT " + apartment;
        }

        return countryName + " " + townName + " " + street + " " + apt;
    }

}
