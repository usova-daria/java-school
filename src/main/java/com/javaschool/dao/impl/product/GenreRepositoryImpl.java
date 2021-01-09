package com.javaschool.dao.impl.product;

import com.javaschool.dao.api.product.GenreRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.entity.product.Genre;
import org.springframework.stereotype.Repository;

@Repository
public class GenreRepositoryImpl extends AbstractRepositoryImpl<Genre, Integer> implements GenreRepository {

    public GenreRepositoryImpl() {
        super(Genre.class);
    }

}
