package com.javaschool.domainlogic.user.profile.dto.orderpreview;

import com.javaschool.entity.order.enumeration.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * @author Daria Usova
 */
@Data
@NoArgsConstructor
public class UserOrderPreviewInfo {

    /**
     * Order id
     */
    private Long orderId;

    /**
     * Order status
     */
    private OrderStatus orderStatus;

    /**
     * Date order was created
     */
    private String createdDate;

    /**
     * Total
     */
    private Double total;

    /**
     * Instantiates a new User order preview info.
     *
     * @param orderId     the order id
     * @param orderStatus the order status
     * @param createdDate the created date
     * @param total       the total
     */
    public UserOrderPreviewInfo(Long orderId, String orderStatus, LocalDate createdDate, Double total) {
        this.orderId = orderId;
        this.orderStatus = OrderStatus.valueOf(orderStatus);
        this.createdDate = createdDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                                                               .withLocale(Locale.ENGLISH));
        this.total = total;
    }

}
