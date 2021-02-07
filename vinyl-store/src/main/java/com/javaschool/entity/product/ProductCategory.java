package com.javaschool.entity.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "product_category")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_category_id")
    private Integer id;

    @Column(name = "name")
    @NotNull
    @Size(min = 1, max = 45)
    private String name;

    @OneToMany(
            mappedBy = "category",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                       CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @ToString.Exclude
    private List<Product> products;

}
