package com.javaschool.domainlogic.order.checkout.mapper.impl;

import com.javaschool.dao.api.address.CountryRepository;
import com.javaschool.dao.api.address.TownRepository;
import com.javaschool.domainlogic.order.checkout.exception.AddressMappingException;
import com.javaschool.domainlogic.order.checkout.mapper.api.AddressMapper;
import com.javaschool.domainlogic.order.checkout.dto.AddressDto;
import com.javaschool.entity.address.Address;
import com.javaschool.entity.address.Country;
import com.javaschool.entity.address.Town;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AddressMapperImpl implements AddressMapper {

    private final TownRepository townRepository;
    private final CountryRepository countryRepository;

    @Override
    public Address toEntity(AddressDto addressDto) {
        if ( addressDto == null ) {
            throw new AddressMappingException("AddressDto must not be null");
        }

        Address address = new Address();

        address.setPostalCode( addressDto.getPostalCode() );
        address.setStreet( addressDto.getStreet() );
        address.setBuilding( addressDto.getBuilding() );
        address.setApartment( addressDto.getApartment() );

        Integer countryId = addressDto.getCountryId();
        Country country = countryRepository.findById( countryId )
                .orElseThrow(() -> new AddressMappingException(("There is no country with id=" + countryId)));

        address.setCountry(country);

        Integer townId = addressDto.getTownId();
        Town town = townRepository.findById( townId )
                .orElseThrow(() -> new AddressMappingException(("There is no town with id=" + townId)));

        address.setTown(town);
        return address;
    }

}
