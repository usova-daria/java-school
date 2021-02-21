package com.javaschool.domainlogic.order.checkout.mapper.api;

import com.javaschool.domainlogic.order.checkout.dto.CountryDto;
import com.javaschool.entity.address.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CountryMapper {

    CountryDto toDto(Country country);

    List<CountryDto> toDtoList(List<Country> countries);

}
