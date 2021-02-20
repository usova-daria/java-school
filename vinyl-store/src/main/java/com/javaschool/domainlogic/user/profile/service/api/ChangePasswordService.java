package com.javaschool.domainlogic.user.profile.service.api;

import com.javaschool.domainlogic.user.profile.dto.password.ChangePasswordDto;

public interface ChangePasswordService {

    boolean isCorrectPassword(String password);

    void changePassword(ChangePasswordDto changePasswordDto);

}
