package com.javaschool.entity.product;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "genre")
@NamedQueries({
        @NamedQuery(name = "Genre.findAllOrderById",
                query = "SELECT g FROM Genre g order by g.id"),

        @NamedQuery(name = "Genre.findNumberOfRecords",
                query = "SELECT coalesce(count(r), 0) from Record r where r.genre.id = :genre_id")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Integer id;

    @NotNull
    @Column(name = "name")
    @Size(min = 1, max = 45)
    private String name;

    @OneToMany(
            mappedBy = "genre",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @ToString.Exclude
    private List<Record> records;

}
