package com.javaschool.dao.api.product;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.entity.product.Genre;
import com.javaschool.entity.product.Record;

import java.util.List;

public interface RecordRepository extends AbstractRepository<Record, Long> {

    List<Record> findByGenre(Genre genre);

    List<Record> findByGenreAndDeletedFalse(Genre genre);

}
