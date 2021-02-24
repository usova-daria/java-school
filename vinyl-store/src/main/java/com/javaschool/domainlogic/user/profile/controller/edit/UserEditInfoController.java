package com.javaschool.domainlogic.user.profile.controller.edit;

import com.javaschool.domainlogic.user.profile.dto.edit.UserEditInfoDto;
import com.javaschool.domainlogic.user.profile.exception.edit.UserInfoNotUpdatedException;
import com.javaschool.domainlogic.user.profile.service.api.edit.UserEditInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.Month;

@Log4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/profile/edit")
public class UserEditInfoController {

    private final UserEditInfoService userEditInfoService;

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

    @ExceptionHandler(UserInfoNotUpdatedException.class)
    public String handleUserInfoNotUpdatedException(UserInfoNotUpdatedException e, RedirectAttributes ra) {
        ra.addFlashAttribute("error", "An error occurred, but it's not your fault. Please, try again later");
        return "redirect:/profile/edit";
    }

}
