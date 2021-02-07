package com.javaschool.domainlogic.admin.productmanagement.service.api;

import com.javaschool.domainlogic.admin.productmanagement.dto.GenreDto;
import com.javaschool.entity.product.Genre;

import java.util.List;

public interface GenreService {

    List<GenreDto> getGenreDtoList();

    List<GenreDto> getGenreDtoListOrderById();

    GenreDto saveGenre(GenreDto genreDto);

    GenreDto updateGenre(GenreDto genreDto);

    Genre findById(Integer id);

    GenreDto saveOrUpdate(GenreDto genreDto);

    void deleteById(Integer id);

}
