package com.javaschool.domainlogic.user.profile.service.impl;

import com.javaschool.domainlogic.user.profile.dto.password.ChangePasswordDto;
import com.javaschool.domainlogic.user.profile.exception.password.ChangePasswordException;
import com.javaschool.domainlogic.user.profile.exception.UserNotFoundException;
import com.javaschool.domainlogic.user.profile.service.api.ChangePasswordService;
import com.javaschool.entity.user.User;
import com.javaschool.service.api.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;

@Log4j
@Service
@RequiredArgsConstructor
public class ChangePasswordServiceImpl implements ChangePasswordService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean isCorrectPassword(String password) {
        User user = getCurrentUser();
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    @Transactional
    public void changePassword(ChangePasswordDto changePasswordDto) {
        User user = getCurrentUser();

        String encodedPassword = passwordEncoder.encode( changePasswordDto.getNewPassword() );
        user.setPassword(encodedPassword);

        try {
            userService.update(user);
        } catch (PersistenceException e) {
            log.error("An error occurred while changing user password", e);
            throw new ChangePasswordException("Password has not been changed", e);
        }
    }

    private User getCurrentUser() {
        try {
            return userService.getCurrentUser();
        } catch (PersistenceException | UserNotFoundException e) {
            log.error("An error occurred while getting current user", e);
            throw new ChangePasswordException("User not found", e);
        }
    }

}
