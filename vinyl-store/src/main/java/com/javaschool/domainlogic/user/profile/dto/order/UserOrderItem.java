package com.javaschool.domainlogic.user.profile.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderItem {

    private Long id;
    private String name;

    @ToString.Exclude
    private String picture;

    private float price;
    private int quantity;

}
