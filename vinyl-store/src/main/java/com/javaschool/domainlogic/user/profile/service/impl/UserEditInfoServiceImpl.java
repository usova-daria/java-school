package com.javaschool.domainlogic.user.profile.service.impl;

import com.javaschool.domainlogic.user.profile.dto.edit.UserEditInfoDto;
import com.javaschool.domainlogic.user.profile.mapper.UserEditInfoMapper;
import com.javaschool.domainlogic.user.profile.service.api.UserEditInfoService;
import com.javaschool.domainlogic.user.registration.mapper.api.BirthdayMapper;
import com.javaschool.entity.user.User;
import com.javaschool.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class UserEditInfoServiceImpl implements UserEditInfoService {

    @Autowired
    private UserService userService;

    @Autowired
    private BirthdayMapper birthdayMapper;

    @Autowired
    private UserEditInfoMapper userMapper;

    @Override
    @Transactional
    public void updateUserInfo(UserEditInfoDto userEditInfoDto) {
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
        User user = userService.getCurrentUser();
        return userMapper.toDto(user);
    }

}
