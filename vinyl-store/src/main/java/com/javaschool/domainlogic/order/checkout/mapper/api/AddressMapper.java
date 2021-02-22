package com.javaschool.domainlogic.order.checkout.mapper.api;

import com.javaschool.domainlogic.order.checkout.dto.AddressDto;
import com.javaschool.entity.address.Address;

public interface AddressMapper {

    Address toEntity(AddressDto addressDto);

}
