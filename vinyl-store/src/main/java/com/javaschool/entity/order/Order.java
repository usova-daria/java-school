package com.javaschool.entity.order;

import com.javaschool.domainlogic.user.profile.dto.orderpreview.UserOrderPreviewInfo;
import com.javaschool.entity.address.Address;
import com.javaschool.entity.order.enumeration.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "`order`")
@Data
@EqualsAndHashCode(of = {"id"})
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "order-graph",
                attributeNodes = {
                        @NamedAttributeNode(value = "address", subgraph = "address-subgraph"),
                        @NamedAttributeNode("shippingMethod"),
                        @NamedAttributeNode("paymentDetails"),
                        @NamedAttributeNode("recipient")
                },
                subgraphs = @NamedSubgraph(
                        name = "address-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("town"),
                                @NamedAttributeNode("country")
                        }
                )
        )
})
@NamedQueries(
        @NamedQuery(name = "Order.findOrderItemPicturesByOrderId",
                    query = "SELECT p.picture from Product p " +
                            "inner join OrderItem oi on p.id = oi.product.id " +
                            "where oi.order.id = :order_id")
)
@NamedNativeQuery(
        name = "Order.findUserOrderPreviewInfoByUserId",
        query = "SELECT o.order_id as id, o.status as status, o.created as created, pd.amount as total " +
                "FROM `order` o " +
                "inner join customer_has_order cho on o.order_id = cho.order_id " +
                "inner join payment_details pd on o.payment_details_id = pd.payment_details_id " +
                "WHERE cho.user_id = :user_id " +
                "order by id desc",
        resultSetMapping = "OrderInfoPreviewInfo"
)
@SqlResultSetMapping(
        name = "OrderInfoPreviewInfo",
        classes = @ConstructorResult(
                targetClass = UserOrderPreviewInfo.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "status", type = String.class),
                        @ColumnResult(name = "created", type = LocalDate.class),
                        @ColumnResult(name = "total", type = Double.class)
                }
        )
)
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "enum")
    @NotNull
    private OrderStatus status;

    @Column(name = "created")
    @CreationTimestamp
    private LocalDate created;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "shipping_method_id", referencedColumnName = "shipping_method_id")
    private ShippingMethod shippingMethod;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_details_id", referencedColumnName = "payment_details_id")
    private PaymentDetails paymentDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id", referencedColumnName = "recipient_id")
    private Recipient recipient;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<OrderItem> items;

}
