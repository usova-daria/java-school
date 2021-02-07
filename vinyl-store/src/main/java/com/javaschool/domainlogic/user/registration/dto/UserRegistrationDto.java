package com.javaschool.domainlogic.user.registration.dto;

import com.javaschool.domainlogic.user.registration.validation.annotation.UserEmailUnique;
import com.javaschool.domainlogic.user.registration.validation.annotation.ValidBirthday;
import com.javaschool.domainlogic.user.registration.validation.annotation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistrationDto {

    /**
     * User first name
     */
    @Length(min = 1, max = 45, message = "{first.name.length}")
    private String firstName;

    /**
     * User last name
     */
    @Length(min = 1, max = 45, message = "{last.name.length}")
    private String lastName;

    /**
     * User email
     */
    @Email(message = "{email.invalid}")
    @UserEmailUnique
    private String email;

    /**
     * User password
     */
    @ValidPassword
    private String password;

    /**
     * User birthday
     */
    @ValidBirthday
    private Birthday birthday;

}
