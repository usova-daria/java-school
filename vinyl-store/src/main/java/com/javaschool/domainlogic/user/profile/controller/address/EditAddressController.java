package com.javaschool.domainlogic.user.profile.controller.address;

import com.javaschool.domainlogic.user.profile.dto.address.EditAddressDto;
import com.javaschool.domainlogic.user.profile.exception.address.AddressUpdateFailException;
import com.javaschool.domainlogic.user.profile.exception.address.UserHasNoSuchAddress;
import com.javaschool.domainlogic.user.profile.service.api.address.EditAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profile/addresses/edit")
public class EditAddressController {

    private final EditAddressService editAddressService;

    @GetMapping("/{id}")
    public String showEditAddressPage(@PathVariable("id") Long addressId, ModelMap modelMap) {
        editAddressService.fillEditModelMap(modelMap, addressId);
        return "user/profile/address";
    }

    @PostMapping
    public ModelAndView updateAddress(@Valid @ModelAttribute("address") EditAddressDto editAddressDto,
                                      BindingResult result, RedirectAttributes ra) {
        if (result.hasErrors()) {
            return editAddressService.getErrorEditModelAndView(editAddressDto);
        }

        editAddressService.updateAddress(editAddressDto);

        ra.addFlashAttribute("success", "Success!");
        return new ModelAndView("redirect:/profile/addresses");
    }

    @ExceptionHandler(UserHasNoSuchAddress.class)
    public String handleUserHasNoSuchOrder() {
        return "access-denied";
    }

    @ExceptionHandler(AddressUpdateFailException.class)
    public String handleAddressUpdateFail(AddressUpdateFailException ex, RedirectAttributes ra) {
        ra.addFlashAttribute("error", "The address has not been updated. Please try again later.");
        return "redirect:/profile/addresses/edit/" + ex.getAddressId();
    }

}
