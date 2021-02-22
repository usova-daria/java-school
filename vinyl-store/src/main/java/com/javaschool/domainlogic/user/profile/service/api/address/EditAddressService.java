package com.javaschool.domainlogic.user.profile.service.api.address;

import com.javaschool.domainlogic.user.profile.dto.address.EditAddressDto;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public interface EditAddressService {

    void fillEditModelMap(ModelMap modelMap, Long addressId);

    EditAddressDto getEditAddressDto(Long addressId);

    ModelAndView getErrorEditModelAndView(EditAddressDto editAddressDto);

    void updateAddress(EditAddressDto editAddressDto);

}
