package com.javaschool.domainlogic.order.checkout.service.impl;

import com.javaschool.dao.api.address.CountryRepository;
import com.javaschool.domainlogic.order.checkout.dto.TownDto;
import com.javaschool.domainlogic.order.checkout.mapper.api.TownMapper;
import com.javaschool.domainlogic.order.checkout.service.api.TownService;
import com.javaschool.entity.address.Country;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class TownServiceImpl implements TownService {

    private final TownMapper townMapper;
    private final CountryRepository countryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TownDto> getTownByCountry(Integer countryId) {
        try {
            return countryRepository.findById(countryId)
                    .map(Country::getTowns)
                    .map(townMapper::toDtoList)
                    .orElse(new ArrayList<>());
        } catch (PersistenceException e) {
            log.error("An error occurred while getting towns by country id", e);
            return new ArrayList<>();
        }
    }

}
