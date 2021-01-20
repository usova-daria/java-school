package com.javaschool.domainlogic.user.registration.mapper;

import com.javaschool.domainlogic.user.registration.dto.Birthday;
import com.javaschool.domainlogic.user.registration.dto.UserRegistrationDto;
import com.javaschool.entity.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;

@Mapper
public interface UserRegistrationMapper {

    /**
     * Maps {@link UserRegistrationDto} user dto to {@link User} user entity
     *
     * @param userDto user dto
     * @return user entity
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "customerInfo", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "orders", ignore = true)
    User toEntity(UserRegistrationDto userDto);

    default LocalDate birthdayToLocalDate(Birthday birthday) {
        return LocalDate.of(birthday.getYear(), birthday.getMonth(), birthday.getDay());
    }

}
