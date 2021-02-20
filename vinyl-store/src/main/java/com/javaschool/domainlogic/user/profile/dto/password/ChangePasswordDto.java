package com.javaschool.domainlogic.user.profile.dto.password;

import com.javaschool.domainlogic.user.profile.validation.annotation.CorrectPassword;
import com.javaschool.domainlogic.user.profile.validation.annotation.EqualPasswords;
import com.javaschool.domainlogic.user.registration.validation.annotation.ValidPassword;
import lombok.Data;

@Data
@EqualPasswords
public class ChangePasswordDto {

    @CorrectPassword
    private String currentPassword;

    @ValidPassword
    private String newPassword;

    private String confirmPassword;

}
