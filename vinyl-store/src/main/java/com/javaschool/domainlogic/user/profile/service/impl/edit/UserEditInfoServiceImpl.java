package com.javaschool.domainlogic.user.profile.service.impl.edit;

import com.javaschool.domainlogic.user.profile.dto.edit.UserEditInfoDto;
import com.javaschool.domainlogic.user.profile.exception.edit.GetUserInfoException;
import com.javaschool.domainlogic.user.profile.exception.edit.UserInfoNotUpdatedException;
import com.javaschool.domainlogic.user.profile.mapper.order.UserEditInfoMapper;
import com.javaschool.domainlogic.user.profile.service.api.edit.UserEditInfoService;
import com.javaschool.domainlogic.user.registration.mapper.api.BirthdayMapper;
import com.javaschool.entity.user.User;
import com.javaschool.service.api.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.time.LocalDate;

@Log4j
@Service
@RequiredArgsConstructor
public class UserEditInfoServiceImpl implements UserEditInfoService {

    private final UserService userService;
    private final BirthdayMapper birthdayMapper;
    private final UserEditInfoMapper userMapper;

    @Override
    @Transactional
    public void updateUserInfo(UserEditInfoDto userEditInfoDto) {
       try {
           tryToUpdateUserInfo(userEditInfoDto);
       } catch (PersistenceException e) {
           log.error("An error occurred while updating user info", e);
           throw new UserInfoNotUpdatedException();
       }
    }

    private void tryToUpdateUserInfo(UserEditInfoDto userEditInfoDto) {
        User user = userService.getCurrentUser();

        user.setFirstName( userEditInfoDto.getFirstName() );
        user.setLastName( userEditInfoDto.getLastName() );

        LocalDate birthday = birthdayMapper.toLocalDate( userEditInfoDto.getBirthday() );
        user.setBirthday(birthday);

        userService.update(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserEditInfoDto getCurrentUserEditInfoDto() {
        try {
            User user = userService.getCurrentUser();
            return userMapper.toDto(user);
        } catch (PersistenceException e) {
            log.error("An error occurred while getting current user edit info dto", e);
            throw new GetUserInfoException();
        }
    }

}
