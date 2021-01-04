package com.javaschool.entity.order;

import com.javaschool.entity.product.Product;
import com.javaschool.entity.order.id.OrderItemId;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_item")
@Data
public class OrderItem {

    @EmbeddedId
    private OrderItemId id;

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
    private int amount;

    @Column(name = "price")
    @NotNull
    private float price;

}
