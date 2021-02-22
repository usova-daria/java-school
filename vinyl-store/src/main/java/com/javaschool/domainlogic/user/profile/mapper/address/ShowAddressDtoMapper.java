package com.javaschool.domainlogic.user.profile.mapper.address;

import com.javaschool.domainlogic.user.profile.dto.address.ShowAddressDto;
import com.javaschool.entity.address.Address;
import com.javaschool.util.AddressUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ShowAddressDtoMapper {

    @Mapping(target = "address", source = "address")
    @Mapping(target = "id", source = "id")
    ShowAddressDto toDto(Address address);

    List<ShowAddressDto> toDtoList(List<Address> addressList);

    default String addressToString(Address address) {
        return AddressUtil.addressToString(address);
    }

}
