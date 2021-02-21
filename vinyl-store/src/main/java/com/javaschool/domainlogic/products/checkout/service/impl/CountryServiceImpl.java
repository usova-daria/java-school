package com.javaschool.domainlogic.products.checkout.service.impl;

import com.javaschool.dao.api.address.CountryRepository;
import com.javaschool.domainlogic.products.checkout.dto.CountryDto;
import com.javaschool.domainlogic.products.checkout.mapper.api.CountryMapper;
import com.javaschool.domainlogic.products.checkout.service.api.CountryService;
import com.javaschool.entity.address.Country;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryMapper countryMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CountryDto> getCountries() {
        List<Country> countries;
        try {
            countries = countryRepository.findAll();
        } catch (PersistenceException e) {
            log.error("An error occurred while getting all countries", e);
            countries = new ArrayList<>();
        }

        return countryMapper.toDtoList(countries);
    }
}
