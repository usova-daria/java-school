package com.javaschool.domainlogic.user.profile.service.impl.address;

import com.javaschool.domainlogic.order.checkout.dto.CountryDto;
import com.javaschool.domainlogic.order.checkout.dto.TownDto;
import com.javaschool.domainlogic.order.checkout.service.api.CountryService;
import com.javaschool.domainlogic.order.checkout.service.api.TownService;
import com.javaschool.domainlogic.user.profile.dto.address.EditAddressDto;
import com.javaschool.domainlogic.user.profile.exception.AddressUpdateFailException;
import com.javaschool.domainlogic.user.profile.exception.UserHasNoSuchAddress;
import com.javaschool.domainlogic.user.profile.mapper.address.AddressToEditAddressDtoMapper;
import com.javaschool.domainlogic.user.profile.service.api.address.EditAddressService;
import com.javaschool.entity.address.Address;
import com.javaschool.entity.address.Town;
import com.javaschool.exception.TownNotFoundException;
import com.javaschool.service.api.AddressService;
import com.javaschool.service.api.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Objects;

@Log4j
@Service
@RequiredArgsConstructor
public class EditAddressServiceImpl implements EditAddressService {

    private final AddressToEditAddressDtoMapper entityToDtoMapper;
    private final CountryService countryService;
    private final TownService townService;
    private final UserService userService;
    private final AddressService addressService;

    @Override
    @Transactional(readOnly = true)
    public void fillEditModelMap(ModelMap modelMap, Long addressId) {
        List<CountryDto> countries = countryService.getCountries();
        EditAddressDto editAddressDto = getEditAddressDto(addressId);
        List<TownDto> towns = townService.getTownByCountry(editAddressDto.getCountryId());

        modelMap.put("countries", countries);
        modelMap.put("address", editAddressDto);
        modelMap.put("towns", towns);
        modelMap.put("action", "/profile/addresses/edit");
    }

    @Override
    @Transactional(readOnly = true)
    public EditAddressDto getEditAddressDto(Long addressId) {
        if (!userService.currentUserHasAddress(addressId)) {
            throw new UserHasNoSuchAddress();
        }

        Address address = addressService.getAddressById(addressId);
        return entityToDtoMapper.toDto(address);
    }

    @Override
    @Transactional(readOnly = true)
    public ModelAndView getErrorEditModelAndView(EditAddressDto editAddressDto) {
        ModelAndView modelAndView = new ModelAndView("user/profile/address");

        List<CountryDto> countries = countryService.getCountries();
        List<TownDto> towns = townService.getTownByCountry(editAddressDto.getCountryId());

        modelAndView.addObject("countries", countries);
        modelAndView.addObject("towns", towns);
        modelAndView.addObject("action", "/profile/addresses/edit");

        return modelAndView;
    }

    @Override
    @Transactional
    public void updateAddress(EditAddressDto editAddressDto) {
        try {
            Address address = addressService.getAddressById(editAddressDto.getId());

            boolean updateTown = !Objects.equals( address.getTown().getId(), editAddressDto.getTownId() );
            if (updateTown) {
                Town town = townService.getTownById(editAddressDto.getTownId() );
                address.setTown(town);
            }

            boolean updateCountry = !Objects.equals( address.getCountry().getId(), editAddressDto.getCountryId() );
            if (updateCountry) {
                address.setCountry( address.getTown().getCountry() );
            }

            address.setApartment( editAddressDto.getApartment() );
            address.setBuilding( editAddressDto.getBuilding() );
            address.setPostalCode( editAddressDto.getPostalCode() );
            address.setStreet( editAddressDto.getStreet() );

            addressService.update(address);
        } catch (TownNotFoundException | PersistenceException e) {
            log.error("An error occurred while updating address", e);
            throw new AddressUpdateFailException(editAddressDto.getId());
        }
    }

}
