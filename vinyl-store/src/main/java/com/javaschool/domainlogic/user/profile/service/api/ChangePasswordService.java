package com.javaschool.domainlogic.user.profile.service.api;

import com.javaschool.domainlogic.user.profile.dto.password.ChangePasswordDto;

/**
 * @author Daria Usova
 */
public interface ChangePasswordService {

    /**
     * Checks if provided password is correct.
     *
     * @param password the password
     * @return the boolean
     */
    boolean isCorrectPassword(String password);

    /**
     * Changes user password.
     *
     * @param changePasswordDto the change password dto
     */
    void changePassword(ChangePasswordDto changePasswordDto);

}
