package com.javaschool.domainlogic.user.profile.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DeleteAddressResponseFactory {

    private DeleteAddressResponseFactory() { }

    private static final String OK = "The address has been deleted.";
    private static final String NO_SUCH_ADDRESS = "The user has no such address.";
    private static final String FAILED = "Failed to delete the address. Please try again later!";


    public static ResponseEntity<DeleteAddressResponse> getOk(Long addressId) {
        DeleteAddressResponse response = new DeleteAddressResponse(OK, addressId);
        return ResponseEntity.ok().body(response);
    }

    public static ResponseEntity<DeleteAddressResponse> getNoSuchAddress(Long addressId) {
        DeleteAddressResponse response = new DeleteAddressResponse(NO_SUCH_ADDRESS, addressId);
        return ResponseEntity.badRequest().body(response);
    }

    public static ResponseEntity<DeleteAddressResponse> getDeleteAddressFail(Long addressId) {
        DeleteAddressResponse response = new DeleteAddressResponse(FAILED, addressId);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
