package com.javaschool.domainlogic.admin.productmanagment.service.api;

import com.javaschool.domainlogic.admin.productmanagment.dto.GenreDto;
import com.javaschool.entity.product.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    List<GenreDto> getGenreDtoList();

    List<GenreDto> getGenreDtoListOrderById();

    GenreDto saveGenre(GenreDto genreDto);

    GenreDto updateGenre(GenreDto genreDto);

    Genre findById(Integer id);

    GenreDto saveOrUpdate(GenreDto genreDto);

    void deleteById(Integer id);

}
