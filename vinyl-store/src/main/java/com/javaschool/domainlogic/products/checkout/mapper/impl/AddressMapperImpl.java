package com.javaschool.domainlogic.products.checkout.mapper.impl;

import com.javaschool.dao.api.address.CountryRepository;
import com.javaschool.dao.api.address.TownRepository;
import com.javaschool.domainlogic.products.checkout.dto.AddressDto;
import com.javaschool.domainlogic.products.checkout.mapper.api.AddressMapper;
import com.javaschool.entity.address.Address;
import com.javaschool.entity.address.Country;
import com.javaschool.entity.address.Town;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperImpl implements AddressMapper {

    @Autowired
    private TownRepository townRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Address toEntity(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setPostalCode( addressDto.getPostalCode() );
        address.setStreet( addressDto.getStreet() );
        address.setBuilding( addressDto.getBuilding() );
        address.setApartment( addressDto.getApartment() );

        Country country = countryRepository.findById(addressDto.getCountryId())
                .orElseThrow(() -> new IllegalArgumentException("An error occurred while mapping checkoutFormDto. " +
                        "There is no country with id=" + addressDto.getCountryId()));

        address.setCountry(country);

        Town town = townRepository.findById(addressDto.getTownId())
                .orElseThrow(() -> new IllegalArgumentException("An error occurred while mapping checkoutFormDto. " +
                        "There is no town with id=" + addressDto.getTownId()));

        address.setTown(town);

        return address;
    }

}
