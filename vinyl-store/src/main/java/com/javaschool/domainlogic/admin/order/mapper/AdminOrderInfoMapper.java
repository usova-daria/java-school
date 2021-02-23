package com.javaschool.domainlogic.admin.order.mapper;

import com.javaschool.domainlogic.admin.order.dto.AdminOrderInfo;
import com.javaschool.util.AddressUtil;
import com.javaschool.entity.address.Address;
import com.javaschool.entity.order.Order;
import com.javaschool.entity.order.Recipient;
import com.javaschool.util.RecipientUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

/**
 * @author Daria Usova
 */
@Mapper
public interface AdminOrderInfoMapper {

    /**
     * Maps {@link Order} order entity to {@link AdminOrderInfo} order dto
     *
     * @param order order entity
     * @return order dto
     */
    @Mapping(target = "orderStatus", source = "status")
    @Mapping(target = "paymentMethod", source = "paymentDetails.method")
    @Mapping(target = "paymentStatus", source = "paymentDetails.status")
    @Mapping(target = "shippingCompany", source = "shippingMethod.companyName")
    @Mapping(target = "recipientContacts", source = "recipient")
    @Mapping(target = "createdDate", source = "created")
    AdminOrderInfo toDto(Order order);

    /**
     * Returns string representation of given {@link Address} address entity
     *
     * @param address address entity
     * @return a string representation of an address
     */
    default String addressToString(Address address) {
        return AddressUtil.addressToString(address);
    }

    /**
     * Returns string representation of given {@link Recipient} recipient entity
     *
     * @param recipient recipient entity
     * @return a string representation of a recipient
     */
    default String recipientToString(Recipient recipient) {
        return RecipientUtil.recipientToString(recipient);
    }

    /**
     * Maps order entity list to order dto list
     *
     * @param orders order entity list
     * @return order dto list
     */
    List<AdminOrderInfo> toDtoList(List<Order> orders);

    /**
     * Created to string.
     *
     * @param created the created local date
     * @return the string
     */
    default String createdToString(LocalDate created) {
        if (created == null) return "NA";
        return created.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.ENGLISH));
    }

}
