package com.javaschool.domainlogic.user.profile.service.impl.address;

import com.javaschool.domainlogic.order.checkout.dto.AddressDto;
import com.javaschool.domainlogic.order.checkout.dto.CountryDto;
import com.javaschool.domainlogic.order.checkout.dto.TownDto;
import com.javaschool.domainlogic.order.checkout.service.api.CountryService;
import com.javaschool.domainlogic.order.checkout.service.api.TownService;
import com.javaschool.domainlogic.user.profile.service.api.address.AddNewAddressService;
import com.javaschool.service.api.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddNewAddressServiceImpl implements AddNewAddressService {

    private final CountryService countryService;
    private final AddressService addressService;
    private final TownService townService;

    @Override
    public void fillModelMap(ModelMap modelMap) {
        List<CountryDto> countries = countryService.getCountries();
        AddressDto addressDto = new AddressDto();

        modelMap.put("countries", countries);
        modelMap.put("address", addressDto);

        modelMap.put("action", "/profile/addresses/create");
    }

    @Override
    @Transactional(readOnly = true)
    public ModelAndView getErrorModelAndView(AddressDto addressDto) {
        ModelAndView modelAndView = new ModelAndView("user/profile/address");

        List<CountryDto> countries = countryService.getCountries();
        List<TownDto> towns = townService.getTownByCountry(addressDto.getCountryId());

        modelAndView.addObject("countries", countries);
        modelAndView.addObject("towns", towns);
        modelAndView.addObject("action", "/profile/addresses/create");

        return modelAndView;
    }

    @Override
    @Transactional
    public void saveAddress(AddressDto addressDto) {
        addressService.save(addressDto);
    }
}
