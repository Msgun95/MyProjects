package myproject.ecommerse.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ItemDTO {

    private String name;
    private String description;
    private Double price;
}
