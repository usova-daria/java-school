package com.javaschool.domainlogic.admin.productmanagment.service.api;

import com.javaschool.domainlogic.admin.productmanagment.dto.GenreDto;
import com.javaschool.entity.product.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    List<GenreDto> getGenreDtoList();

    void saveGenre(GenreDto genreDto);

    void updateGenre(GenreDto genreDto);

    Genre findById(Integer id);

}
