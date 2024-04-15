package myproject.ecommerse.repository;

import myproject.ecommerse.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
