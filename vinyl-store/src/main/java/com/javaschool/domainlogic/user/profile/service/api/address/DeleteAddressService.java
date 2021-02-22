package com.javaschool.domainlogic.user.profile.service.api.address;

import com.javaschool.domainlogic.user.profile.response.DeleteAddressResponse;
import org.springframework.http.ResponseEntity;

public interface DeleteAddressService {

    ResponseEntity<DeleteAddressResponse> deleteAddressById(Long addressId);

}
