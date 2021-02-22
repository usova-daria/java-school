package com.javaschool.domainlogic.rest;

import com.javaschool.domainlogic.order.checkout.dto.TownDto;
import com.javaschool.domainlogic.order.checkout.service.api.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TownRestController {

    @Autowired
    private TownService townService;

    @GetMapping(value = "/towns/{id}", produces = "application/json")
    public List<TownDto> getTownsByCountryId(@PathVariable("id") Integer countryId) {
        return townService.getTownByCountry(countryId);
    }

}
