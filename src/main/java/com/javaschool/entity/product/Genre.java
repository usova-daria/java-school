package com.javaschool.entity.product;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "genre")
@NamedQuery(name = "Genre.findAllOrderById",
        query = "SELECT g FROM Genre g order by g.id"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Integer id;

    @Column(name = "name")
    @NotNull
    @Size(min = 1, max = 45)
    private String name;

    @OneToMany(
            mappedBy = "genre",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                       CascadeType.PERSIST, CascadeType.REFRESH}
    )
    private List<Record> records;

}
