package myproject.ecommerse.dto;


import lombok.Data;

import myproject.ecommerse.model.Address;
import myproject.ecommerse.model.CreditCard;
import myproject.ecommerse.model.Order;
import myproject.ecommerse.model.Review;

import java.util.List;

@Data

public class CustomerDTO {

    private String firstName;
    private String lastName;
    private String email;

    private List<Address> addressList;


    private List<CreditCard> creditCardList;


    private List<Order> orderList;


    private List<Review> reviews;


}
