package com.javaschool.domainlogic.user.registration.controller;

import com.javaschool.domainlogic.user.registration.dto.UserRegistrationDto;
import com.javaschool.domainlogic.user.registration.exception.UserRegistrationException;
import com.javaschool.domainlogic.user.registration.service.api.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.Month;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @ModelAttribute("months")
    private Month[] monthList() {
        return Month.values();
    }

    @GetMapping
    public String showRegistrationPage(ModelMap modelMap) {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        modelMap.addAttribute("user", userRegistrationDto);

        return "user/register";
    }

    @PostMapping
    public String addRecord(@Valid @ModelAttribute("user") UserRegistrationDto user,
                            BindingResult result, RedirectAttributes ra) {
        if (result.hasErrors()) {
            return "user/register";
        }

        userRegistrationService.registerUser(user);
        ra.addFlashAttribute("success", "Success!");

        return "redirect:/register";
    }

    @ExceptionHandler(UserRegistrationException.class)
    public String handleUserRegistrationException(UserRegistrationException e, RedirectAttributes ra) {
        ra.addFlashAttribute("error", "An error occurred, but it's not your fault. Please try again later");

        return "redirect:/register";
    }

}
