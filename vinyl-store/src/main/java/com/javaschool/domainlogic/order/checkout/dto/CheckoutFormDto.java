package com.javaschool.domainlogic.order.checkout.dto;

import com.javaschool.entity.order.enumeration.PaymentMethod;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Daria Usova
 */
@Data
@ToString
@NoArgsConstructor
public class CheckoutFormDto {

    /**
     * Recipient first name
     */
    @NotNull(message = "{last.name.null}")
    @Length(min = 1, max = 45, message = "{first.name.length}")
    private String firstName;

    /**
     * Recipient last name
     */
    @NotNull(message = "{last.name.null}")
    @Length(min = 1, max = 45, message = "{last.name.length}")
    private String lastName;

    /**
     * Recipient phone number
     */
    @NotNull(message = "{phone.number.null}")
    @Pattern(regexp = "\\d{4}-\\d{3}-\\d{2}-\\d{2}", message = "{phone.number.format}")
    private String phoneNumber;

    /**
     * Recipient address
     */
    @Valid
    private AddressDto address;

    /**
     * Payment method
     */
    @NotNull(message = "{payment.method.required}")
    private PaymentMethod paymentMethod;

    /**
     * Delivery method id
     */
    @NotNull(message = "{delivery.method.required}")
    private Integer deliveryMethodId;

}
