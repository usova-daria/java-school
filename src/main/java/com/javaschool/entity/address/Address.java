package com.javaschool.entity.address;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "postal_code")
    @Size(min = 1, max = 12)
    @NotNull
    private String postalCode;

    @Column(name = "street")
    @Size(min = 1, max = 45)
    @NotNull
    private String street;

    @Column(name = "building")
    @Size(min = 1, max = 10)
    @NotNull
    private String building;

    @Column(name = "apartment")
    @Size(min = 1, max = 10)
    private String apartment;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "town_id")
    private Town town;

}
