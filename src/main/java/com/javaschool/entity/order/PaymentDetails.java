package com.javaschool.entity.order;

import com.javaschool.entity.order.enumeration.PaymentMethod;
import com.javaschool.entity.order.enumeration.PaymentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "payment_details")
@Data
@NoArgsConstructor
public class PaymentDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_details_id")
    private Long id;

    @Column(name = "amount")
    @NotNull
    private float amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "enum")
    @NotNull
    private PaymentStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", columnDefinition = "enum")
    @NotNull
    private PaymentMethod method;

    public PaymentDetails(float amount, PaymentStatus status, PaymentMethod method) {
        this.amount = amount;
        this.status = status;
        this.method = method;
    }

}
