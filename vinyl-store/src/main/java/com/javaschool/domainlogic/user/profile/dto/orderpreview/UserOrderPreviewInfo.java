package com.javaschool.domainlogic.user.profile.dto.orderpreview;

import com.javaschool.entity.order.enumeration.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Data
@NoArgsConstructor
public class UserOrderPreviewInfo {

    private Long orderId;

    private OrderStatus orderStatus;

    private String createdDate;

    private Double total;

    public UserOrderPreviewInfo(Long orderId, String orderStatus, LocalDate createdDate, Double total) {
        this.orderId = orderId;
        this.orderStatus = OrderStatus.valueOf(orderStatus);
        this.createdDate = createdDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                                                               .withLocale(Locale.ENGLISH));
        this.total = total;
    }

}
