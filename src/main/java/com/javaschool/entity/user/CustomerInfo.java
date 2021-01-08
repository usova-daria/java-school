package com.javaschool.entity.user;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customer_info")
@Data
public class CustomerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_info_id")
    private Long id;

    @Column(name = "bonuses")
    @NotNull
    private int bonuses;

}
