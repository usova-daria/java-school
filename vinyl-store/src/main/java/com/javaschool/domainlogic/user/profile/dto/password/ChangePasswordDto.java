package com.javaschool.domainlogic.user.profile.dto.password;

import com.javaschool.domainlogic.user.profile.validation.annotation.CorrectPassword;
import com.javaschool.domainlogic.user.profile.validation.annotation.EqualPasswords;
import com.javaschool.domainlogic.user.registration.validation.annotation.ValidPassword;
import lombok.Data;

/**
 * @author Daria Usova
 */
@Data
@EqualPasswords
public class ChangePasswordDto {

    /**
     * Current password
     */
    @CorrectPassword
    private String currentPassword;

    /**
     * New password
     */
    @ValidPassword
    private String newPassword;

    /**
     * Password confirmation field
     */
    private String confirmPassword;

}
