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
public class Item {

    @Id
    @GeneratedValue
    private Integer itemId;
    private String name;
    private String description;
    private Double price;
    private Integer qauntityAvailable;


    @OneToMany(mappedBy = "item",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviews;


}
