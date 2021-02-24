package com.javaschool.domainlogic.user.profile.service.api.address;

import com.javaschool.domainlogic.user.profile.dto.address.ShowAddressDto;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface UserAddressService {

    /**
     * Gets address list.
     *
     * @return the address list
     */
    List<ShowAddressDto> getAddressList();

}
