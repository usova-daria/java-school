package com.javaschool.domainlogic.user.profile.service.api;

import com.javaschool.domainlogic.user.profile.dto.order.UserOrder;

public interface UserOrderService {

    UserOrder getUserOrderByOrderId(Long id);

}
