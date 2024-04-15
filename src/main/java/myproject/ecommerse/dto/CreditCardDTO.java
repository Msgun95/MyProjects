package myproject.ecommerse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import myproject.ecommerse.model.Customer;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDTO {

    private Long cardnumber;
    private LocalDate expireDate;
    private Integer securityNumber;
    private Customer customerId;
}
