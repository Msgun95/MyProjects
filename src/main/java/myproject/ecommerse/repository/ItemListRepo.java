package myproject.ecommerse.repository;

import myproject.ecommerse.model.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemListRepo extends JpaRepository<ItemList, Integer> {
}
