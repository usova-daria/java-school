package com.javaschool.domainlogic.user.profile.exception;

public class AddressUpdateFailException extends RuntimeException {

    private Long addressId;

    public AddressUpdateFailException() {
    }

    public AddressUpdateFailException(Long addressId) {
        super();
        this.addressId = addressId;
    }

    public AddressUpdateFailException(String message) {
        super(message);
    }

    public AddressUpdateFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public Long getAddressId() {
        return addressId;
    }

}
