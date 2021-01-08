package com.javaschool.dao.api.product;

import com.javaschool.dao.api.AbstractDao;
import com.javaschool.entity.product.Genre;
import com.javaschool.entity.product.Record;

import java.util.List;

public interface RecordDao extends AbstractDao<Record, Long> {

    List<Record> findByGenre(Genre genre);

    List<Record> findByGenreAndDeletedFalse(Genre genre);

}
