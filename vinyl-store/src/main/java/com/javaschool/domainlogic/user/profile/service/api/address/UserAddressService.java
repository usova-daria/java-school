package com.javaschool.domainlogic.user.profile.service.api.address;

import com.javaschool.domainlogic.user.profile.dto.address.ShowAddressDto;

import java.util.List;

public interface UserAddressService {

    List<ShowAddressDto> getAddressList();

}
