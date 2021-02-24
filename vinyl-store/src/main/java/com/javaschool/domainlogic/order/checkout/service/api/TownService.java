package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.domainlogic.order.checkout.dto.TownDto;
import com.javaschool.entity.address.Town;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface TownService {

    /**
     * Gets town by country.
     *
     * @param countryId the country id
     * @return the town by country
     */
    List<TownDto> getTownByCountry(Integer countryId);

    /**
     * Gets town by id.
     *
     * @param id the id
     * @return the town by id
     */
    Town getTownById(Integer id);

}
