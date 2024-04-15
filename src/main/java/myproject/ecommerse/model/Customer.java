package myproject.ecommerse.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {


    @Id
    @GeneratedValue
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    @OneToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private List<Address> addressList;


    @JoinColumn(name = "customer_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CreditCard> creditCards;

    @JoinColumn(name = "customer_id")
 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> orderList;

    @JoinColumn(name = "customer_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviews;

}