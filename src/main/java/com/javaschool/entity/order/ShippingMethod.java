package com.javaschool.entity.order;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "shipping_method")
@Data
public class ShippingMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_method_id")
    private Integer id;

    @Column(name = "company_name")
    @NotNull
    @Size(min = 1, max = 45)
    private String companyName;

}
