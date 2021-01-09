package com.javaschool.dao.impl.product;

import com.javaschool.dao.api.product.MusicianRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.entity.product.Musician;
import org.springframework.stereotype.Repository;

@Repository
public class MusicianRepositoryImpl extends AbstractRepositoryImpl<Musician, Integer> implements MusicianRepository {

    public MusicianRepositoryImpl() {
        super(Musician.class);
    }

}
