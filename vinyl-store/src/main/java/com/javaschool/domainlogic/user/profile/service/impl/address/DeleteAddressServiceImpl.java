package com.javaschool.domainlogic.user.profile.service.impl.address;

import com.javaschool.domainlogic.user.profile.response.DeleteAddressResponse;
import com.javaschool.domainlogic.user.profile.response.DeleteAddressResponseFactory;
import com.javaschool.domainlogic.user.profile.service.api.address.DeleteAddressService;
import com.javaschool.service.api.AddressService;
import com.javaschool.service.api.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j
@Service
@RequiredArgsConstructor
public class DeleteAddressServiceImpl implements DeleteAddressService {

    private final UserService userService;
    private final AddressService addressService;

    @Override
    @Transactional
    public ResponseEntity<DeleteAddressResponse> deleteAddressById(Long addressId) {
        if (!userService.currentUserHasAddress(addressId)) {
            return DeleteAddressResponseFactory.getNoSuchAddress(addressId);
        }

        boolean deleted = addressService.deleteById(addressId);
        if (!deleted) {
            return DeleteAddressResponseFactory.getDeleteAddressFail(addressId);
        }

        return DeleteAddressResponseFactory.getOk(addressId);
    }

}
