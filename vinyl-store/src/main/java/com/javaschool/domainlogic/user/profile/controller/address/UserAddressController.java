package com.javaschool.domainlogic.user.profile.controller.address;

import com.javaschool.domainlogic.user.profile.service.api.address.UserAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profile/addresses")
public class UserAddressController {

    private final UserAddressService userAddressService;

    @GetMapping
    public String showAddressesPage(ModelMap modelMap) {
        modelMap.put("addresses", userAddressService.getAddressList());
        return "user/profile/addresses";
    }

}
