package com.javaschool.domainlogic.products.checkout.mapper.api;

import com.javaschool.domainlogic.products.checkout.dto.TownDto;
import com.javaschool.entity.address.Town;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TownMapper {

    TownDto toDto(Town town);

    List<TownDto> toDtoList(List<Town> list);

}
