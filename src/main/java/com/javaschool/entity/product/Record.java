package com.javaschool.entity.product;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "record")
@Data
@EqualsAndHashCode(callSuper = true)
public class Record extends Product {

    @Column(name = "album")
    @Size(min = 1, max = 45)
    @NotNull
    private String albumName;

    @Column(name = "year")
    @NotNull
    private int year;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                       CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "musician_has_record",
            joinColumns = @JoinColumn(name = "record_id"),
            inverseJoinColumns = @JoinColumn(name = "musician_id")
    )
    @NotNull
    private List<Musician> musician;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
    private Genre genre;

}
