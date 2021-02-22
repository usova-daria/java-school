package com.javaschool.domainlogic.user.profile.controller.address;

import com.javaschool.domainlogic.order.checkout.dto.AddressDto;
import com.javaschool.domainlogic.user.profile.exception.AddressNotSavedException;
import com.javaschool.domainlogic.user.profile.service.api.address.AddNewAddressService;
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
@RequestMapping("/profile/addresses/create")
public class AddNewAddressController {

    private final AddNewAddressService addNewAddressService;

    @GetMapping
    public String showAddNewOrderPage(ModelMap modelMap) {
        addNewAddressService.fillModelMap(modelMap);
        return "user/profile/address";
    }

    @PostMapping
    public ModelAndView saveAddress(@Valid @ModelAttribute("address") AddressDto addressDto,
                                    BindingResult result, RedirectAttributes ra) {
        if (result.hasErrors()) {
            return addNewAddressService.getErrorModelAndView(addressDto);
        }

        addNewAddressService.saveAddress(addressDto);
        ra.addFlashAttribute("success", "Success!");
        return new ModelAndView("redirect:/profile/addresses");
    }

    @ExceptionHandler(AddressNotSavedException.class)
    public String handleAddressNotSavedException(RedirectAttributes ra) {
        ra.addFlashAttribute("error", "An error occurred while saving an address. Please try again later!");
        return "redirect:/profile/addresses";
    }

}
