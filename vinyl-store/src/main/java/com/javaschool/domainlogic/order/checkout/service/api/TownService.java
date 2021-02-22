package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.checkout.dto.TownDto;
import com.javaschool.entity.address.Town;

import java.util.List;

public interface TownService {

    List<TownDto> getTownByCountry(Integer countryId);

    Town getTownById(Integer id);

}
