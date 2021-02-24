package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.checkout.dto.CountryDto;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface CountryService {

    /**
     * Gets countries.
     *
     * @return the countries
     */
    List<CountryDto> getCountries();

}
