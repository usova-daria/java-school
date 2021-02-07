package com.javaschool.domainlogic.products.checkout.service.impl;

import com.javaschool.dao.api.address.CountryRepository;
import com.javaschool.domainlogic.products.checkout.dto.CountryDto;
import com.javaschool.domainlogic.products.checkout.mapper.api.CountryMapper;
import com.javaschool.domainlogic.products.checkout.service.api.CountryService;
import com.javaschool.entity.address.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public List<CountryDto> getCountries() {
        List<Country> countries = countryRepository.findAll();
        return countryMapper.toDtoList(countries);
    }
}
