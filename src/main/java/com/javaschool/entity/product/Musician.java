package com.javaschool.entity.product;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "musician")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString
public class Musician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "musician_id")
    private Integer id;

    @Column(name = "name")
    @Size(min = 1, max = 80)
    @NotNull
    private String name;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                       CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "musician_has_record",
            joinColumns = @JoinColumn(name = "musician_id"),
            inverseJoinColumns = @JoinColumn(name = "record_id")
    )
    @ToString.Exclude
    private List<Record> records;

}
