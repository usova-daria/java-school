package com.javaschool.dao.impl.product;

import com.javaschool.dao.api.product.RecordDao;
import com.javaschool.dao.impl.AbstractDaoImpl;
import com.javaschool.entity.product.Genre;
import com.javaschool.entity.product.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordDaoImpl extends AbstractDaoImpl<Record, Long> implements RecordDao {

    public RecordDaoImpl() {
        super(Record.class);
    }

    @Override
    public List<Record> findByGenre(Genre genre) {
        return entityManager.createNamedQuery("Record.findByGenre", Record.class)
                .setParameter("genre", genre)
                .getResultList();
    }

    @Override
    public List<Record> findByGenreAndDeletedFalse(Genre genre) {
        return entityManager.createNamedQuery("Record.findByGenreAndDeletedFalse", Record.class)
                .setParameter("genre", genre)
                .getResultList();
    }

}
