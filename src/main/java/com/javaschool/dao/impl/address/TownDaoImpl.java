package com.javaschool.dao.impl.address;

import com.javaschool.dao.api.address.TownDao;
import com.javaschool.dao.impl.AbstractDaoImpl;
import com.javaschool.entity.address.Town;

public class TownDaoImpl extends AbstractDaoImpl<Town, Integer> implements TownDao {

    public TownDaoImpl() {
        super(Town.class);
    }
}
