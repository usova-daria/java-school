package com.javaschool.domainlogic.user.profile.service.api.edit;

import com.javaschool.domainlogic.user.profile.dto.edit.UserEditInfoDto;

/**
 * @author Daria Usova
 */
public interface UserEditInfoService {

    /**
     * Updates user info.
     *
     * @param userEditInfoDto the user edit info dto
     */
    void updateUserInfo(UserEditInfoDto userEditInfoDto);

    /**
     * Gets current user edit info dto.
     *
     * @return the current user edit info dto
     */
    UserEditInfoDto getCurrentUserEditInfoDto();

}
