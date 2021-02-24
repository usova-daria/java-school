package com.javaschool.domainlogic.user.profile.exception.address;

public class AddressUpdateFailException extends RuntimeException {

    private final Long addressId;

    public AddressUpdateFailException(Long addressId) {
        super();
        this.addressId = addressId;
    }

    public AddressUpdateFailException(String message, Long addressId) {
        super(message);
        this.addressId = addressId;
    }

    public AddressUpdateFailException(String message, Throwable cause, Long addressId) {
        super(message, cause);
        this.addressId = addressId;
    }

    public Long getAddressId() {
        return addressId;
    }

}
