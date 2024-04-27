package myproject.ecommerse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import myproject.ecommerse.enum1.OrderState;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Order_table")
public class Order {

    @Id
    @GeneratedValue
    private Integer orderId;
    private LocalDateTime createdAt;
    private Double totalPrice;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    private List<Item> itemsList;

    @Enumerated
    private OrderState state;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Address shippingAddress;



}
