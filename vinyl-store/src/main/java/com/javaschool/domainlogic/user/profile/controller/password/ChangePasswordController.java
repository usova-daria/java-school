package com.javaschool.domainlogic.user.profile.controller.password;

import com.javaschool.domainlogic.user.profile.dto.password.ChangePasswordDto;
import com.javaschool.domainlogic.user.profile.exception.ChangePasswordException;
import com.javaschool.domainlogic.user.profile.service.api.ChangePasswordService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Log4j
@Controller
@RequestMapping("/profile/change-password")
public class ChangePasswordController {

    @Autowired
    private ChangePasswordService changePasswordService;

    private final String CHANGE_PASSWORD_PAGE = "user/profile/change-password";
    private final String CHANGE_PASSWORD_REDIRECT = "redirect:/profile/change-password";

    @GetMapping
    public String showChangePasswordPage(ModelMap modelMap) {
        modelMap.put("changePasswordDto", new ChangePasswordDto());
        return CHANGE_PASSWORD_PAGE;
    }

    @PostMapping
    public String changePassword(@Valid @ModelAttribute("changePasswordDto") ChangePasswordDto changePasswordDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes ra) {
        if (bindingResult.hasErrors()) {
            return CHANGE_PASSWORD_PAGE;
        }

        changePasswordService.changePassword(changePasswordDto);

        ra.addFlashAttribute("success", "Success!");
        return CHANGE_PASSWORD_REDIRECT;
    }

    @ExceptionHandler(ChangePasswordException.class)
    public String handleUserNotFoundException(ChangePasswordException e, RedirectAttributes ra) {
        ra.addFlashAttribute("error", "An error occurred, but it's not your fault. Please, try again later");

        return CHANGE_PASSWORD_REDIRECT;
    }

}
