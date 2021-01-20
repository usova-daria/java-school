package com.javaschool.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "role")
@NamedQuery(name = "Role.findByName",
            query = "SELECT r from Role r where r.name = :name")
@Data
@EqualsAndHashCode(of = {"id"})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Column(name = "name")
    @Size(min = 1, max = 45)
    @NotNull
    private String name;

}
