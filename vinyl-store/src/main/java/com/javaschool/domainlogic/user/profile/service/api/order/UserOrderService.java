package com.javaschool.domainlogic.user.profile.service.api.order;

import com.javaschool.domainlogic.user.profile.dto.order.UserOrder;

/**
 * @author Daria Usova
 */
public interface UserOrderService {

    /**
     * Gets user order by order id.
     *
     * @param id the id
     * @return the user order by order id
     */
    UserOrder getUserOrderByOrderId(Long id);

}
