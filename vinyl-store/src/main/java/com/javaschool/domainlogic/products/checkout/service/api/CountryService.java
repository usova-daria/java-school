package com.javaschool.domainlogic.products.checkout.service.api;

import com.javaschool.domainlogic.products.checkout.dto.CountryDto;

import java.util.List;

public interface CountryService {

    List<CountryDto> getCountries();

}
