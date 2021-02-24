package com.javaschool.dao.api.product;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.entity.product.Genre;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface GenreRepository extends AbstractRepository<Genre, Integer> {

    /**
     * Find all order by id list.
     *
     * @return the list
     */
    List<Genre> findAllOrderById();

    /**
     * Find number of record by genre id long.
     *
     * @param id the id
     * @return the long
     */
    long findNumberOfRecordByGenreId(Integer id);

}
