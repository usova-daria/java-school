package com.javaschool.domainlogic.order.checkout.mapper.api;

import com.javaschool.domainlogic.order.checkout.dto.CountryDto;
import com.javaschool.entity.address.Country;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Daria Usova
 */
@Mapper
public interface CountryMapper {

    /**
     * Maps country to country dto.
     *
     * @param country the country
     * @return the country dto
     */
    CountryDto toDto(Country country);

    /**
     * Maps countries entity list to country dto list.
     *
     * @param countries the countries
     * @return the list
     */
    List<CountryDto> toDtoList(List<Country> countries);

}
