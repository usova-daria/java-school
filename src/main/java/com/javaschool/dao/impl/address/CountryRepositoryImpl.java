package com.javaschool.dao.impl.address;

import com.javaschool.dao.api.address.CountryRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.entity.address.Country;
import org.springframework.stereotype.Repository;

@Repository
public class CountryRepositoryImpl extends AbstractRepositoryImpl<Country, Integer> implements CountryRepository {

    public CountryRepositoryImpl() {
        super(Country.class);
    }

}
