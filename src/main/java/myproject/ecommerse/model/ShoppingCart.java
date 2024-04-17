package myproject.ecommerse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ItemList {

    @Id
    @GeneratedValue
    private Integer itemlistId;
    private Integer discount;

    @JoinColumn(name = "itemlistId")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> itemsList;



}
