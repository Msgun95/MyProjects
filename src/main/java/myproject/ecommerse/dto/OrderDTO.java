package myproject.ecommerse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private String New;
    private String processed;
    private String shiped;
    private String delivered;
    private String returned;
}
