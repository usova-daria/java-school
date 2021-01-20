package com.javaschool.entity.product;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "Product.findAndSortBySalesVolume",
                    query = "SELECT new " +
                            "com.javaschool.domainlogic.admin.stats.dto.ProductData(oi.product.id, oi.product.name, sum(oi.amount)) " +
                            "from OrderItem oi group by oi.product order by sum(oi.amount) DESC"),
        @NamedQuery(name = "Product.findByNameContaining",
                query = "SELECT p from Product p where lower(p.name) like lower(concat('%', :name, '%'))"),
        @NamedQuery(name = "Product.findByDeletedFalse",
                    query = "SELECT p from Product p where p.deleted = false")
})
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
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

    @Column(name = "created")
    @CreationTimestamp
    private LocalDate created;

}
