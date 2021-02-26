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
                        "com.javaschool.domainlogic.admin.stats.dto.ProductData" +
                        "(oi.product.id, oi.product.name, sum(oi.amount)) " +
                        "from OrderItem oi group by oi.product order by sum(oi.amount) DESC"),

        @NamedQuery(name = "Product.findByDeletedFalse",
                query = "SELECT new com.javaschool.dao.impl.product.projection.ProductProjection" +
                        "(p.id, p.price, p.name, p.picture, p.unitsInStore)" +
                        " from Product p where p.deleted = false"),

        @NamedQuery(name = "Product.findByDeletedFalseAndSortByPrice",
                query = "SELECT new com.javaschool.dao.impl.product.projection.ProductProjection" +
                        "(p.id, p.price, p.name, p.picture, p.unitsInStore)" +
                        " from Product p where p.deleted = false order by p.price ASC"),

        @NamedQuery(name = "Product.findByDeletedFalseAndSortByCreated",
                query = "SELECT new com.javaschool.dao.impl.product.projection.ProductProjection" +
                        "(p.id, p.price, p.name, p.picture, p.unitsInStore)" +
                        " from Product p where p.deleted = false order by p.id DESC"),

        @NamedQuery(name = "Product.findById",
                query = "SELECT new com.javaschool.dao.impl.product.projection.ProductProjection" +
                        "(p.id, p.price, p.name, p.picture, p.unitsInStore) " +
                        " from Product p where p.id = :id"),

        @NamedQuery(name = "Product.findByIdList",
                query = "SELECT new com.javaschool.dao.impl.product.projection.ProductProjection" +
                        "(p.id, p.price, p.name, p.picture, p.unitsInStore) " +
                        " from Product p where p.id in :idList"),

        @NamedQuery(name = "Product.findUnitsInStoreById",
                query = "SELECT coalesce(p.unitsInStore, 0) from Product p where p.id = :id"),

        @NamedQuery(name = "Product.findUnitsInStoreByIdList",
                query = "SELECT new com.javaschool.dao.impl.product.projection.ProductUnitsInStoreProjection" +
                        "(p.id, coalesce(p.unitsInStore, 0)) from Product p where p.id in :idList"),

        @NamedQuery(name = "Product.findMaxPrice",
                query = "SELECT max(p.price) from Product p where p.deleted = false"),

        @NamedQuery(name = "Product.findMinPrice",
                query = "SELECT min(p.price) from Product p where p.deleted = false"),

        @NamedQuery(name = "Product.findOrderItemProjectionByOrderId",
                query = "SELECT new com.javaschool.dao.impl.product.projection.OrderItemProjection" +
                        "(oi.product.id, oi.product.name, oi.product.picture, oi.price, oi.amount) " +
                        "from OrderItem oi " +
                        "where oi.order.id = :order_id"),

        @NamedQuery(name = "Product.findPrice",
                query = "SELECT new com.javaschool.dao.impl.product.projection.ProductPriceProjection" +
                        "(p.id, p.price) from Product p where p.id in :idList"),

        @NamedQuery(name = "Product.findDeletedById",
                query = "SELECT p.deleted from Product p where p.id = :id"),

        @NamedQuery(name = "Product.findNameAndPriceByIdList",
                    query = "SELECT new com.javaschool.dao.impl.product.projection.ProductNamePriceProjection" +
                            "(p.id, p.price, p.name) from Product p where p.id in :idList")
})
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class Product {

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "price")
    private float price;

    @Column(name = "units_in_store")
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
    @Type(type = "org.hibernate.type.ImageType")
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
