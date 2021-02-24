package com.javaschool.domainlogic.order.checkout.mapper.api;

import com.javaschool.domainlogic.order.checkout.dto.TownDto;
import com.javaschool.entity.address.Town;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Daria Usova
 */
@Mapper
public interface TownMapper {

    /**
     * Maps town entity to town dto.
     *
     * @param town the town
     * @return the town dto
     */
    TownDto toDto(Town town);

    /**
     * Maps town entity list to town dto list.
     *
     * @param list the list
     * @return the list
     */
    List<TownDto> toDtoList(List<Town> list);

}
