package com.javaschool.domainlogic.order.checkout.mapper.api;

import com.javaschool.domainlogic.order.checkout.dto.AddressDto;
import com.javaschool.entity.address.Address;

/**
 * @author Daria Usova
 */
public interface AddressMapper {

    /**
     * Maps address dto to address entity.
     *
     * @param addressDto the address dto
     * @return the address
     */
    Address toEntity(AddressDto addressDto);

}
