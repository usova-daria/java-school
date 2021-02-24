package com.javaschool.dao.impl.product;

import com.javaschool.dao.api.product.GenreRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.entity.product.Genre;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GenreRepositoryImpl extends AbstractRepositoryImpl<Genre, Integer> implements GenreRepository {

    public GenreRepositoryImpl() {
        super(Genre.class);
    }

    @Override
    public List<Genre> findAllOrderById() {
        TypedQuery<Genre> findQuery = entityManager.createNamedQuery("Genre.findAllOrderById", Genre.class);
        return findQuery.getResultList();
    }

    @Override
    public long findNumberOfRecordByGenreId(Integer id) {
        return entityManager.createNamedQuery("Genre.findNumberOfRecords", Long.class)
                .setParameter("genre_id", id)
                .getSingleResult();
    }

}
