package com.javaschool.domainlogic.user.profile.dto.edit;

import com.javaschool.domainlogic.user.registration.dto.Birthday;
import com.javaschool.domainlogic.user.registration.validation.annotation.ValidBirthday;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
 * @author Daria Usova
 */
@Data
@ToString
public class UserEditInfoDto {

    /**
     * User email
     */
    private String email;

    /**
     * First name
     */
    @Length(min = 1, max = 45, message = "{first.name.length}")
    private String firstName;

    /**
     * Last name
     */
    @Length(min = 1, max = 45, message = "{last.name.length}")
    private String lastName;

    /**
     * Birthday
     */
    @ValidBirthday
    private Birthday birthday;

}
