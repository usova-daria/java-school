package com.javaschool.dao.impl.address;

import com.javaschool.dao.api.address.TownRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.entity.address.Town;
import org.springframework.stereotype.Repository;

@Repository
public class TownRepositoryImpl extends AbstractRepositoryImpl<Town, Integer> implements TownRepository {

    public TownRepositoryImpl() {
        super(Town.class);
    }
}
