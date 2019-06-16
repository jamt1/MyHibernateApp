package model.dao;

import model.Order;

import java.util.Collection;
import java.util.List;

public interface OrderDao {

    void add(Order order);

    void update(Order order);

    void delete(Order order);

    Collection<Order> getOrders(String search);

    public List findByOrder(String name, String whom, String whom_from, String status);

}
