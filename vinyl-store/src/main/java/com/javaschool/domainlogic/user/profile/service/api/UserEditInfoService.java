package com.javaschool.domainlogic.user.profile.service.api;

import com.javaschool.domainlogic.user.profile.dto.UserEditInfoDto;

public interface UserEditInfoService {

    void updateUserInfo(UserEditInfoDto userEditInfoDto);

    UserEditInfoDto getCurrentUserEditInfoDto();

}
