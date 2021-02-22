package com.javaschool.domainlogic.user.profile.service.api.address;

import com.javaschool.domainlogic.order.checkout.dto.AddressDto;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public interface AddNewAddressService {

    void fillModelMap(ModelMap modelMap);

    void saveAddress(AddressDto addressDto);

    ModelAndView getErrorModelAndView(AddressDto addressDto);

}
