package com.javaschool.domainlogic.order.checkout.dto;

import com.javaschool.domainlogic.order.checkout.validation.annotation.ValidCardNumber;
import com.javaschool.domainlogic.order.checkout.validation.annotation.ValidExpirationDate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Daria Usova
 */
@Data
public class CardDto {

    /**
     * Card number
     */
    @Length(min = 12, max = 19)
    @Pattern(regexp = "[0-9]+", message = "{card.number.regex}")
    @ValidCardNumber
    private String cardNumber;

    /**
     * Expiration date
     */
    @NotNull(message = "{expiration.required}")
    @Pattern(regexp = "[0-9]{2}/[0-9]{2}", message = "{expiration.regex}")
    @ValidExpirationDate(message = "{card.expired}")
    private String expiration;

    /**
     * CVV code
     */
    @NotNull(message = "{cvv.required}")
    @Pattern(regexp = "[0-9]{3}", message = "{cvv.wrong.format}")
    private String cvv;

}
