package com.javaschool.service.api;

import com.javaschool.domainlogic.order.checkout.dto.AddressDto;
import com.javaschool.entity.address.Address;

public interface AddressService {

    Address getAddressById(Long id);

    void update(Address address);

    boolean deleteById(Long addressId);

    void save(AddressDto address);

}
