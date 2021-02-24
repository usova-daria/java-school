package com.javaschool.domainlogic.user.registration.service.api;

import com.javaschool.domainlogic.user.registration.dto.UserRegistrationDto;

/**
 * @author Daria Usova
 */
public interface UserRegistrationService {

    /**
     * Checks if email already exists.
     *
     * @param email the email
     * @return the boolean
     */
    boolean emailExists(String email);

    /**
     * Register user.
     *
     * @param userRegistrationDto the user registration dto
     */
    void registerUser(UserRegistrationDto userRegistrationDto);

}
