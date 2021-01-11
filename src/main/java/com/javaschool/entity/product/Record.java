package com.javaschool.entity.product;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "record")
@NamedQueries({
        @NamedQuery(name = "Record.findByGenre",
                query = "SELECT r from Record r where r.genre = :genre"),
        @NamedQuery(name = "Record.findByGenreAndDeletedFalse",
                query = "SELECT r from Record r where r.genre = :genre and r.deleted = false")
})
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
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
    private List<Musician> musician;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
    private Genre genre;

    @Builder(builderMethodName = "rBuilder")
    public Record(Long id, float price, int unitsInStore, String name,
                  boolean deleted, byte[] picture, String description, ProductCategory category,
                  String albumName, int year, List<Musician> musician, Genre genre) {
        super(id, price, unitsInStore, name, deleted, picture, description, category);
        this.albumName = albumName;
        this.year = year;
        this.musician = musician;
        this.genre = genre;
    }
}
