package com.javaschool.domainlogic.user.profile.controller.info;

import com.javaschool.domainlogic.user.profile.dto.edit.UserEditInfoDto;
import com.javaschool.domainlogic.user.profile.exception.UserNotFoundException;
import com.javaschool.domainlogic.user.profile.service.api.UserEditInfoService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.Month;

@Log4j
@Controller
@RequestMapping("/profile/edit")
public class UserEditInfoController {

    @Autowired
    private UserEditInfoService userEditInfoService;

    @ModelAttribute("months")
    private Month[] monthList() {
        return Month.values();
    }

    @GetMapping
    public String showEditPage(ModelMap modelMap) {
        UserEditInfoDto user = userEditInfoService.getCurrentUserEditInfoDto();

        modelMap.addAttribute("user", user);
        return "/user/profile/edit";
    }

    @PostMapping
    public String updateUserInfo(@Valid @ModelAttribute("user") UserEditInfoDto userEditInfoDto,
                                 BindingResult result, RedirectAttributes ra) {
        if (result.hasErrors()) {
            return "user/profile/edit";
        }

        userEditInfoService.updateUserInfo(userEditInfoDto);
        ra.addFlashAttribute("success", "Success!");

        return "redirect:/profile/edit";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(UserNotFoundException e, RedirectAttributes ra) {
        log.error("An error occurred while editing user info", e);
        ra.addFlashAttribute("error", "An error occurred, but it's not your fault. Please, try again later");

        return "redirect:/profile/edit";
    }

}
