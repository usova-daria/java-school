package com.javaschool.domainlogic.user.profile.service.api.address;

import com.javaschool.domainlogic.order.checkout.dto.AddressDto;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Daria Usova
 */
public interface AddNewAddressService {

    /**
     * Fills model map.
     *
     * @param modelMap the model map
     */
    void fillModelMap(ModelMap modelMap);

    /**
     * Saves address.
     *
     * @param addressDto the address dto
     */
    void saveAddress(AddressDto addressDto);

    /**
     * Gets error model and view.
     *
     * @param addressDto the address dto
     * @return the error model and view
     */
    ModelAndView getErrorModelAndView(AddressDto addressDto);

}
