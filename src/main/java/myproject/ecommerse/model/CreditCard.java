package myproject.ecommerse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditCard {

    @Id
    @GeneratedValue
    private Integer id;
    private Long cardnumber;
    private LocalDate expireDate;
    private Integer securityNumber;

}
