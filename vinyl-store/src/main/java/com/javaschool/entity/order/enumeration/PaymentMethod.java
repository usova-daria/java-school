package com.javaschool.entity.order.enumeration;

public enum PaymentMethod {

    CREDIT_CARD("Credit card"),
    DEBIT_CARD("Debit card");

    private String methodName;

    PaymentMethod(String method) {
        this.methodName = method;
    }

    public String getMethodName() {
        return methodName;
    }
}
