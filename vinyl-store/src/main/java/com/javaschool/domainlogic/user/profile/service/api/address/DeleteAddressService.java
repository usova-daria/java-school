package com.javaschool.domainlogic.user.profile.service.api.address;

import com.javaschool.domainlogic.user.profile.response.DeleteAddressResponse;
import org.springframework.http.ResponseEntity;

/**
 * @author Daria Usova
 */
public interface DeleteAddressService {

    /**
     * Deletes address by id.
     *
     * @param addressId the address id
     * @return the response entity
     */
    ResponseEntity<DeleteAddressResponse> deleteAddressById(Long addressId);

}
