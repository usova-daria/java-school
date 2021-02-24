package com.javaschool.domainlogic.admin.productmanagement.mapper;

import com.javaschool.domainlogic.admin.productmanagement.dto.GenreDto;
import com.javaschool.entity.product.Genre;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

/**
 * @author Daria Usova
 */
@Mapper
public interface GenreMapper {

    /**
     * Maps {@link Genre} genre entity to {@link GenreDto} genre dto
     *
     * @param genre genre entity
     * @return genre dto
     */
    @InheritInverseConfiguration
    GenreDto toDto(Genre genre);

    /**
     * Maps genre dto to genre entity
     *
     * @param genreDto genre dto
     * @return genre entity
     */
    @Mapping(target = "records", ignore = true)
    Genre toEntity(GenreDto genreDto);

    /**
     * Maps genre entity list to genre dto list
     *
     * @param genreList genre entity list
     * @return genre dto list
     */
    List<GenreDto> toDtoList(List<Genre> genreList);

    /**
     * Maps genre dto list to genre entity list
     *
     * @param genreDtoList genre dto list
     * @return genre entity list
     */
    List<Genre> toEntityList(List<GenreDto> genreDtoList);

}
