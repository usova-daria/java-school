package com.javaschool.entity.order;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "recipient")
@Data
@EqualsAndHashCode(of = {"id"})
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipient_id")
    private Long id;

    @Column(name = "name")
    @NotNull
    @Size(min = 1, max = 90)
    private String name;

    @Column(name = "phone_number")
    @NotNull
    @Size(min = 1, max = 11)
    private String phoneNumber;

}
