package com.javaschool.domainlogic.admin.order.dto;

import com.javaschool.entity.order.enumeration.OrderStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Daria Usova
 */
@Data
public class UpdateOrderStatusDto implements Serializable {

    /**
     * Order id
     */
    private Long id;

    /**
     * Order status
     */
    private OrderStatus status;

}
