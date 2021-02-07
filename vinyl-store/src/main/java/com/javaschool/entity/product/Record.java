package com.javaschool.entity.product;

import com.javaschool.entity.converter.YearConverter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Year;
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
@ToString
public class Record extends Product {

    @Column(name = "album")
    @Size(min = 1, max = 45)
    @NotNull
    private String albumName;

    @Column(name = "year", columnDefinition = "YEAR")
    @Convert(converter = YearConverter.class)
    private Year year;

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
    @ToString.Exclude
    private List<Musician> musicians;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
    private Genre genre;

}
