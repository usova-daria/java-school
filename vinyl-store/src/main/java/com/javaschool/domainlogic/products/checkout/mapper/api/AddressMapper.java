package com.javaschool.domainlogic.products.checkout.mapper.api;

import com.javaschool.domainlogic.products.checkout.dto.AddressDto;
import com.javaschool.entity.address.Address;

public interface AddressMapper {

    Address toEntity(AddressDto addressDto);

}
