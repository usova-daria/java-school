package com.javaschool.domainlogic.user.profile.mapper.address;

import com.javaschool.domainlogic.user.profile.dto.address.EditAddressDto;
import com.javaschool.entity.address.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AddressToEditAddressDtoMapper {

    @Mapping(target = "countryId", source = "country.id")
    @Mapping(target = "townId", source = "town.id")
    EditAddressDto toDto(Address address);

}
