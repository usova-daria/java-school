package com.javaschool.domainlogic.order.checkout.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressDto {

    private Long id;

    private String street;

    private String building;

    private String apartment;

    private Integer countryId;
    private String countryName;

    private Integer townId;
    private String townName;

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
