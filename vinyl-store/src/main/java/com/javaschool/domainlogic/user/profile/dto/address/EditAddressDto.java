package com.javaschool.domainlogic.user.profile.dto.address;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class EditAddressDto {

    private Long id;

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
