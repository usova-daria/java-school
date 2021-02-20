package com.javaschool.domainlogic.products.checkout.service.api;

import com.javaschool.domainlogic.products.checkout.dto.TownDto;

import java.util.List;

public interface TownService {

    List<TownDto> getTownByCountry(Integer countryId);

}
