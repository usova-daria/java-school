package com.javaschool.service.api;

import com.javaschool.domainlogic.order.checkout.dto.AddressDto;
import com.javaschool.entity.address.Address;

/**
 * @author Daria Usova
 */
public interface AddressService {

    /**
     * Gets address by id.
     *
     * @param id the id
     * @return the address by id
     */
    Address getAddressById(Long id);

    /**
     * Update address.
     *
     * @param address the address
     */
    void update(Address address);

    /**
     * Delete by id.
     *
     * @param addressId the address id
     * @return the boolean
     */
    boolean deleteById(Long addressId);

    /**
     * Save address.
     *
     * @param address the address
     */
    void save(AddressDto address);

}
