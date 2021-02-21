package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.checkout.dto.TownDto;

import java.util.List;

public interface TownService {

    List<TownDto> getTownByCountry(Integer countryId);

}
