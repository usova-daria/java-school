package com.javaschool.domainlogic.user.profile.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class UserOrder {

    private UserOrderInfo orderInfo;
    private List<UserOrderItem> items;

    public UserOrder() {
        orderInfo = new UserOrderInfo();
        items = new ArrayList<>();
    }
}
