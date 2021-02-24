package com.javaschool.domainlogic.user.profile.service.api.orderpreview;

import com.javaschool.domainlogic.user.profile.dto.orderpreview.UserOrderPreview;

import java.util.List;

/**
 * @author Daria Usova
 */
public interface UserOrderPreviewService {

    /**
     * Gets orders of current user.
     *
     * @return the orders of current user
     */
    List<UserOrderPreview> getOrdersOfCurrentUser();

}
