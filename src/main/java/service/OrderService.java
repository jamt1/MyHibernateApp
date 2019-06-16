package service;

import model.Order;

import java.util.Collection;


public interface OrderService {

    Boolean add(Order order);

    void update(Order order);

    Collection<Order> getOrders(String search);

    void delete(Order order);

}
