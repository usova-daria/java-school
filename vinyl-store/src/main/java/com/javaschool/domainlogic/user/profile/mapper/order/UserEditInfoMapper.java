package com.javaschool.domainlogic.user.profile.mapper.order;

import com.javaschool.domainlogic.user.profile.dto.edit.UserEditInfoDto;
import com.javaschool.domainlogic.user.registration.mapper.api.BirthdayMapper;
import com.javaschool.entity.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Daria Usova
 */
@Mapper(uses = {BirthdayMapper.class})
public interface UserEditInfoMapper {

    /**
     * Maps user to user edit info dto.
     *
     * @param user the user
     * @return the user edit info dto
     */
    @Mapping(target = "birthday", source = "birthday")
    UserEditInfoDto toDto(User user);

}
