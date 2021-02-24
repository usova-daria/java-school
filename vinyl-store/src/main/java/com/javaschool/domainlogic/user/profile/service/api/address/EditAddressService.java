package com.javaschool.domainlogic.user.profile.service.api.address;

import com.javaschool.domainlogic.user.profile.dto.address.EditAddressDto;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Daria Usova
 */
public interface EditAddressService {

    /**
     * Fills edit model map.
     *
     * @param modelMap  the model map
     * @param addressId the address id
     */
    void fillEditModelMap(ModelMap modelMap, Long addressId);

    /**
     * Gets edit address dto.
     *
     * @param addressId the address id
     * @return the edit address dto
     */
    EditAddressDto getEditAddressDto(Long addressId);

    /**
     * Gets error edit model and view.
     *
     * @param editAddressDto the edit address dto
     * @return the error edit model and view
     */
    ModelAndView getErrorEditModelAndView(EditAddressDto editAddressDto);

    /**
     * Updates address.
     *
     * @param editAddressDto the edit address dto
     */
    void updateAddress(EditAddressDto editAddressDto);

}
