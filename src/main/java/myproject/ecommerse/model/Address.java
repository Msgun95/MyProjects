package myproject.ecommerse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import myproject.ecommerse.enum1.AddressType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue
    private Integer addressId; // address_id
    private String street;
    private String city;
    private String state;
    //@Column(length = 16)
    private String zipCode;

    @Enumerated
    private AddressType addressType;

//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
}
