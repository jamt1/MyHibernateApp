package service.impl;

import model.Order;
import model.dao.OrderDao;
import org.springframework.transaction.annotation.Transactional;
import service.OrderService;

import java.util.Collection;
import java.util.List;


public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Transactional
    @Override
    public Boolean add(Order order) {
        List<Order> duplicate = orderDao.findByOrder(order.getName(), order.getWhom(), order.getWhom_from(), order.getStatus());
        if (duplicate.isEmpty()) {
            orderDao.add(order);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public void update(Order order) {
        orderDao.update(order);
    }

    @Transactional
    @Override
    public Collection<Order> getOrders(String search) {
        return orderDao.getOrders(search);
    }

    @Transactional
    @Override
    public void delete(Order order) {
        orderDao.delete(order);
    }

}
