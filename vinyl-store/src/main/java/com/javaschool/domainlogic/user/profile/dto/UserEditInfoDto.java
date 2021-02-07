package com.javaschool.domainlogic.user.profile.dto;

import com.javaschool.domainlogic.user.registration.dto.Birthday;
import com.javaschool.domainlogic.user.registration.validation.annotation.ValidBirthday;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Data
@ToString
public class UserEditInfoDto {

    private String email;

    @Length(min = 1, max = 45, message = "{first.name.length}")
    private String firstName;

    @Length(min = 1, max = 45, message = "{last.name.length}")
    private String lastName;

    @ValidBirthday
    private Birthday birthday;

}
