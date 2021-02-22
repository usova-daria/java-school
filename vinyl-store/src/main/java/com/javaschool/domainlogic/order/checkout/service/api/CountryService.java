package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.checkout.dto.CountryDto;

import java.util.List;

public interface CountryService {

    List<CountryDto> getCountries();

}
