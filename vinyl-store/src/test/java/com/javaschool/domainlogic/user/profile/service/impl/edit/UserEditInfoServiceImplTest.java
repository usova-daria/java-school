package com.javaschool.domainlogic.user.profile.service.impl.edit;

import com.javaschool.domainlogic.user.profile.dto.edit.UserEditInfoDto;
import com.javaschool.domainlogic.user.profile.exception.UserNotFoundException;
import com.javaschool.domainlogic.user.profile.exception.edit.GetUserInfoException;
import com.javaschool.domainlogic.user.profile.exception.edit.UserInfoNotUpdatedException;
import com.javaschool.domainlogic.user.registration.dto.Birthday;
import com.javaschool.domainlogic.user.registration.mapper.api.BirthdayMapper;
import com.javaschool.entity.user.User;
import com.javaschool.service.api.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.PersistenceException;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author Daria Usova
 */
@RunWith(MockitoJUnitRunner.class)
public class UserEditInfoServiceImplTest {

    @Mock
    private UserService userService;

    @Mock
    private BirthdayMapper birthdayMapper = spy(BirthdayMapper.class);

    @InjectMocks
    private UserEditInfoServiceImpl userEditInfoService;

    private UserEditInfoDto userEditInfoDto;
    private User user;
    private Birthday birthday;

    @Before
    public void setUp() {
        birthday = new Birthday();

        userEditInfoDto = new UserEditInfoDto();
        userEditInfoDto.setBirthday(birthday);

        user = new User();

        when(birthdayMapper.toLocalDate(birthday)).thenReturn(LocalDate.MIN);
    }

    @Test
    public void updateUserInfo1() {
        when(userService.getCurrentUser()).thenThrow(UserNotFoundException.class);

        assertThrows(UserInfoNotUpdatedException.class, () ->
                userEditInfoService.updateUserInfo(userEditInfoDto));
    }

    @Test
    public void updateUserInfo2() {
        when(userService.getCurrentUser()).thenReturn(user);
        doThrow(PersistenceException.class).when(userService).update(user);

        assertThrows(UserInfoNotUpdatedException.class, () ->
                userEditInfoService.updateUserInfo(userEditInfoDto));
    }

    @Test
    public void getCurrentUserEditInfoDto1() {
        when(userService.getCurrentUser()).thenThrow(UserNotFoundException.class);

        assertThrows(GetUserInfoException.class, () ->
                userEditInfoService.getCurrentUserEditInfoDto());
    }

    @Test
    public void getCurrentUserEditInfoDto2() {
        when(userService.getCurrentUser()).thenThrow(PersistenceException.class);

        assertThrows(GetUserInfoException.class, () ->
                userEditInfoService.getCurrentUserEditInfoDto());
    }

}