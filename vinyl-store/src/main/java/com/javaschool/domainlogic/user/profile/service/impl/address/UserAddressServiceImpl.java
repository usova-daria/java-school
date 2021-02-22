package com.javaschool.domainlogic.user.profile.service.impl.address;

import com.javaschool.domainlogic.user.profile.dto.address.ShowAddressDto;
import com.javaschool.domainlogic.user.profile.mapper.address.ShowAddressDtoMapper;
import com.javaschool.domainlogic.user.profile.service.api.address.UserAddressService;
import com.javaschool.entity.address.Address;
import com.javaschool.service.api.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
public class UserAddressServiceImpl implements UserAddressService {

    private final UserService userService;
    private final ShowAddressDtoMapper showAddressDtoMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ShowAddressDto> getAddressList() {
        List<Address> addresses = userService.getAddressesOfCurrentUser();
        return showAddressDtoMapper.toDtoList(addresses);
    }

}
