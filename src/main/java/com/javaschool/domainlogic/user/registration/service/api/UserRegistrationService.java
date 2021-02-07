package com.javaschool.domainlogic.user.registration.service.api;

import com.javaschool.domainlogic.user.registration.dto.UserRegistrationDto;

public interface UserRegistrationService {

    boolean emailExists(String email);

    void registerUser(UserRegistrationDto userRegistrationDto);

}
