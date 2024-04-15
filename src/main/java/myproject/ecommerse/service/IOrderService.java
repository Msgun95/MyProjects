package myproject.ecommerse.service;

import myproject.ecommerse.model.Order;

import java.util.List;

public interface IOrderService {

    Order addOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(int id);
    Order deleteOrder(int id);
}
