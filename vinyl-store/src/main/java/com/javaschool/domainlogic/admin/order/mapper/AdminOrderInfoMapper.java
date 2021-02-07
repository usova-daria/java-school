package com.javaschool.domainlogic.admin.order.mapper;

import com.javaschool.domainlogic.admin.order.dto.AdminOrderInfo;
import com.javaschool.util.AddressUtil;
import com.javaschool.entity.address.Address;
import com.javaschool.entity.order.Order;
import com.javaschool.entity.order.Recipient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

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
        if (recipient == null) return null;
        return String.format("%s\n(%s)", recipient.getName(),
                recipient.getPhoneNumber());
    }

    /**
     * Maps order entity list to order dto list
     *
     * @param orders order entity list
     * @return order dto list
     */
    List<AdminOrderInfo> toDtoList(List<Order> orders);

}
