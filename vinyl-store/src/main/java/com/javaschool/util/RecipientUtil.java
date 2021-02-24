package com.javaschool.util;

import com.javaschool.entity.order.Recipient;

public class RecipientUtil {

    private RecipientUtil() {}

    public static String recipientToString(Recipient recipient) {
        if (recipient == null) return "NA";
        return String.format("%s%n(%s)", recipient.getName(),
                recipient.getPhoneNumber());
    }

}
