package com.javaschool.dao.impl.product;

import com.javaschool.dao.api.product.GenreDao;
import com.javaschool.dao.impl.AbstractDaoImpl;
import com.javaschool.entity.product.Genre;
import org.springframework.stereotype.Repository;

@Repository
public class GenreDaoImpl extends AbstractDaoImpl<Genre, Integer> implements GenreDao {

    public GenreDaoImpl() {
        super(Genre.class);
    }

}
