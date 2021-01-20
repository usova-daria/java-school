package com.javaschool.entity.order.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {

    AWAITING_PAYMENT("Awaiting payment"),
    AWAITING_SHIPMENT("Awaiting shipment"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered");

    private String status;

    OrderStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }
}
