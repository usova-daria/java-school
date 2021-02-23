package com.javaschool.domainlogic.admin.order.service.api;

import com.javaschool.domainlogic.admin.order.dto.UpdateOrderStatusDto;
import org.springframework.ui.ModelMap;

/**
 * @author Daria Usova
 */
public interface AdminOrderService {

    /**
     * Fills model map.
     *
     * @param modelMap the model map
     */
    void fillModelMap(ModelMap modelMap);

    /**
     * Updates order status.
     *
     * @param orderStatusDto the order status dto
     */
    void updateOrderStatus(UpdateOrderStatusDto orderStatusDto);

}
