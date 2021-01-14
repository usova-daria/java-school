package com.javaschool.domainlogic.admin.productmanagment.mapper;

import com.javaschool.domainlogic.admin.productmanagment.dto.GenreDto;
import com.javaschool.entity.product.Genre;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper
public interface GenreMapper {

    /**
     * Maps {@link Genre} genre entity to {@link GenreDto} genre dto
     *
     * @param genre genre entity
     * @return genre dto
     */
    GenreDto toDto(Genre genre);

    /**
     * Maps genre dto to genre entity
     *
     * @param genreDto genre dto
     * @return genre entity
     */
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
