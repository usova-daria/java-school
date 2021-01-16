package com.javaschool.domainlogic.admin.productmanagment.mapper;

import com.javaschool.domainlogic.admin.productmanagment.dto.MusicianDto;
import com.javaschool.entity.product.Musician;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface MusicianMapper {

    /**
     * Maps musician entity to musician dto
     *
     * @param musician genre entity
     * @return musician dto
     */
    @InheritInverseConfiguration
    MusicianDto toDto(Musician musician);

    /**
     * Maps musician dto to musician entity
     *
     * @param musicianDto musician dto
     * @return musician entity
     */
    @Mapping(target = "records", ignore = true)
    Musician toEntity(MusicianDto musicianDto);

    /**
     * Maps musician dto list to musician entity list
     *
     * @param musicianDtoList musician dto list
     * @return musician entity list
     */
    List<Musician> toEntityList(List<MusicianDto> musicianDtoList);

    /**
     * Maps musician entity list to musician dto list
     *
     * @param musicianList musician entity list
     * @return musician dto list
     */
    List<MusicianDto> toDTOList(List<Musician> musicianList);

}
