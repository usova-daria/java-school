package com.javaschool.entity.product;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "price")
    @NotNull
    private float price;

    @Column(name = "units_in_store")
    @NotNull
    private int unitsInStore;

    @Column(name = "name")
    @Size(min = 1, max = 70)
    @NotNull
    private String name;

    @Column(name = "deleted", columnDefinition = "BIT", length = 1)
    @NotNull
    private boolean deleted;

    @Column(name = "picture")
    @Lob
    @Type(type="org.hibernate.type.ImageType")
    private byte[] picture;

    @Column(name = "description")
    @Size(max = 2000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "product_category_id")
    private ProductCategory category;

}
