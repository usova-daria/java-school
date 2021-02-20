package com.javaschool.domainlogic.user.profile.service.api;

import com.javaschool.domainlogic.user.profile.dto.orderpreview.UserOrderPreview;

import java.util.List;

public interface UserOrderPreviewService {

    List<UserOrderPreview> getOrdersOfCurrentUser();

}
