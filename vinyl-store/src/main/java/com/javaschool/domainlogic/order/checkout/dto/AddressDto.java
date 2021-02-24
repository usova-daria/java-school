package com.javaschool.domainlogic.order.checkout.dto;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Daria Usova
 */
@Data
@ToString
public class AddressDto {

    @NotNull(message = "{street.null}")
    @Length(min = 1, max = 45, message = "{street.length}")
    private String street;

    @NotNull(message = "{building.null}")
    @Length(min = 1, max = 10, message = "{building.length}")
    private String building;

    @Length(max = 10, message = "{apartment.max.length}")
    private String apartment;

    @NotNull(message = "{country.required}")
    @Min(value = 1, message = "{country.required}")
    private Integer countryId;

    @NotNull(message = "{town.required}")
    @Min(value = 1, message = "{town.required}")
    private Integer townId;

    @NotNull(message = "{postal.code.null}")
    @Length(min = 1, max = 12, message = "{postal.code.length}")
    private String postalCode;

}
