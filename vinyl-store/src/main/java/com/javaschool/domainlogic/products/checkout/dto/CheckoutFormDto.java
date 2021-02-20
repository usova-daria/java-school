package com.javaschool.domainlogic.products.checkout.dto;

import com.javaschool.entity.order.enumeration.PaymentMethod;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@ToString
public class CheckoutFormDto {

    @NotNull(message = "{last.name.null}")
    @Length(min = 1, max = 45, message = "{first.name.length}")
    private String firstName;

    @NotNull(message = "{last.name.null}")
    @Length(min = 1, max = 45, message = "{last.name.length}")
    private String lastName;

    @NotNull(message = "{phone.number.null}")
    @Pattern(regexp = "\\d{4}-\\d{3}-\\d{2}-\\d{2}", message = "{phone.number.format}")
    private String phoneNumber;

    @Valid
    private AddressDto address;

    @NotNull(message = "{payment.method.required}")
    private PaymentMethod paymentMethod;

    @NotNull(message = "{delivery.method.required}")
    private Integer deliveryMethodId;

    public CheckoutFormDto() {
    }

}
