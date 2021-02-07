package com.javaschool.entity.order;

import com.javaschool.entity.product.Product;
import com.javaschool.entity.order.id.OrderItemId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_item")
@NamedQueries(
        @NamedQuery(name = "OrderItem.getGenreUnitsSold",
                    query = "SELECT new com.javaschool.domainlogic.salesdisplay.dto.GenreUnitsSold" +
                            "(coalesce(sum(oi.amount), 0), g.name) " +
                            "from OrderItem oi " +
                            "inner join Record r on oi.product.id = r.id " +
                            "inner join Genre g on r.genre.id = g.id " +
                            "group by r.genre.id")
)
@Data
@EqualsAndHashCode(of = {"id"})
public class OrderItem {

    @EmbeddedId
    private OrderItemId id = new OrderItemId();

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @MapsId("productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @MapsId("orderId")
    private Order order;

    @Column(name = "amount")
    @NotNull
    private Integer amount;

    @Column(name = "price")
    @NotNull
    private Float price;

}
