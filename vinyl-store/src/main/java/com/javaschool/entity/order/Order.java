package com.javaschool.entity.order;

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
