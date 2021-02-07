package com.javaschool.domainlogic.user.registration.mapper.api;

import com.javaschool.domainlogic.user.registration.dto.UserRegistrationDto;
import com.javaschool.entity.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {BirthdayMapper.class})
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

}
