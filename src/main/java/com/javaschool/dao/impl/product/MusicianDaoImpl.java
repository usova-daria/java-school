package com.javaschool.dao.impl.product;

import com.javaschool.dao.api.product.MusicianDao;
import com.javaschool.dao.impl.AbstractDaoImpl;
import com.javaschool.entity.product.Musician;

public class MusicianDaoImpl extends AbstractDaoImpl<Musician, Integer> implements MusicianDao {

    public MusicianDaoImpl() {
        super(Musician.class);
    }

}
