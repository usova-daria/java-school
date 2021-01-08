package com.javaschool.dao.impl.address;

import com.javaschool.dao.api.address.CountryDao;
import com.javaschool.dao.impl.AbstractDaoImpl;
import com.javaschool.entity.address.Country;

public class CountryDaoImpl extends AbstractDaoImpl<Country, Integer> implements CountryDao {

    public CountryDaoImpl() {
        super(Country.class);
    }

}
