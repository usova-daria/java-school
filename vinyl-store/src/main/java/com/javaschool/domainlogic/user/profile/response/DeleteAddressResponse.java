package com.javaschool.domainlogic.user.profile.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteAddressResponse {

    private String message;
    private Long addressId;

}
