package com.javaschool.domainlogic.order.checkout.mapper.api;

import com.javaschool.domainlogic.order.checkout.dto.UserAddressDto;
import com.javaschool.entity.address.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserAddressDtoMapper {

    @Mapping(target = "countryId", source = "country.id")
    @Mapping(target = "countryName", source = "country.name")
    @Mapping(target = "townId", source = "town.id")
    @Mapping(target = "townName", source = "town.name")
    @Mapping(target = "id", source = "id")
    UserAddressDto toDto(Address address);

    List<UserAddressDto> toDtoList(List<Address> addressList);

}
