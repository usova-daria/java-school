package com.javaschool.dao.api.product;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.entity.product.Genre;

import java.util.List;

public interface GenreRepository extends AbstractRepository<Genre, Integer> {

    List<Genre> findAllOrderById();

    long findNumberOfRecordByGenreId(Integer id);

}
