package com.javaschool.domainlogic.products.checkout.service.impl;

import com.javaschool.dao.api.address.CountryRepository;
import com.javaschool.domainlogic.products.checkout.dto.TownDto;
import com.javaschool.domainlogic.products.checkout.mapper.api.TownMapper;
import com.javaschool.domainlogic.products.checkout.service.api.TownService;
import com.javaschool.entity.address.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TownServiceImpl implements TownService {

    @Autowired
    private TownMapper townMapper;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<TownDto> getTownByCountry(Integer countryId) {
        return countryRepository.findById(countryId)
                .map(Country::getTowns)
                .map(townMapper::toDtoList)
                .orElse(new ArrayList<>());
    }

}
