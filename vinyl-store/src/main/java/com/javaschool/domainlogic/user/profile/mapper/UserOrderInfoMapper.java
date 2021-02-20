package com.javaschool.domainlogic.user.profile.mapper;

import com.javaschool.domainlogic.user.profile.dto.order.UserOrderInfo;
import com.javaschool.entity.address.Address;
import com.javaschool.entity.order.Order;
import com.javaschool.entity.order.PaymentDetails;
import com.javaschool.entity.order.Recipient;
import com.javaschool.entity.order.ShippingMethod;
import com.javaschool.entity.order.enumeration.PaymentMethod;
import com.javaschool.util.AddressUtil;
import com.javaschool.util.RecipientUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Mapper
public interface UserOrderInfoMapper {

    @Mapping(target = "address", source = "address")
    @Mapping(target = "contacts", source = "recipient")
    @Mapping(target = "deliveryMethod", source = "shippingMethod")
    @Mapping(target = "createdDate", source = "created")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "paymentMethod", source = "paymentDetails")
    @Mapping(target = "total", source = "paymentDetails.amount")
    UserOrderInfo toDto(Order order);

    default String addressToString(Address address) {
        return AddressUtil.addressToString(address);
    }

    default String recipientToString(Recipient recipient) {
        return RecipientUtil.recipientToString(recipient);
    }

    default String shippingMethodToString(ShippingMethod shippingMethod) {
        if (shippingMethod == null) return "NA";
        return shippingMethod.getCompanyName();
    }

    default String createdToString(LocalDate created) {
        if (created == null) return "NA";
        return created.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                                               .withLocale(Locale.ENGLISH));
    }

    default PaymentMethod paymentDetailsToPaymentMethod(PaymentDetails paymentDetails) {
        return paymentDetails.getMethod();
    }

}
