package com.javaschool.domainlogic.user.profile.controller.address;

import com.javaschool.domainlogic.user.profile.response.DeleteAddressResponse;
import com.javaschool.domainlogic.user.profile.service.api.address.DeleteAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile/addresses/delete")
public class DeleteAddressController {

    private final DeleteAddressService deleteAddressService;

    @PostMapping("/{id}")
    public ResponseEntity<DeleteAddressResponse> removeAddress(@PathVariable("id") Long addressId) {
        return deleteAddressService.deleteAddressById(addressId);
    }

}
