package myproject.ecommerse.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import myproject.ecommerse.enum1.Role;
import myproject.ecommerse.model.*;

import java.util.List;

@Data

public class CustomerDTO {

//    private String firstName;
//    private String lastName;
//    private String email;

//    @NotBlank(message = "firstname is required")
//    @Size(min = 2, max = 20)
    private String firstName;

//    @NotBlank(message = "lastname is required")
//    @Size(min = 2, max = 20)
    private String lastName;


//    @Size(min = 10, max = 40)
//    @NotBlank(message = "Email is required")
//    @Email(message = "Email should be valid")
//    @NotEmpty(message = "Email is required")
    private String email;

   // @NotBlank(message = "Email is required")
    private String password;

   // @NotBlank(message = "Email is required")
    private Role role;



    private List<Address> addressList;


    private List<CreditCard> creditCardList;


    private List<Order> orderList;


    private List<Review> reviews;


}
