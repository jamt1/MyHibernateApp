package model.dao.impl;

import model.Order;
import model.dao.OrderDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    private EntityManager emf;

    @Override
    public void add(Order order) {
        emf.persist(order);
    }

    @Override
    public void update(Order order) {
        emf.merge(order);
    }

    @Override
    public void delete(Order order) {
        emf.remove(emf.getReference(Order.class, order.getId()));
    }

    @Override
    public Collection<Order> getOrders(String search) {
        if (null == search || search.trim().isEmpty()) {
            return emf.createQuery(
                    "select c from Order c")
                    .getResultList();
        }
        return emf.createQuery(
                "select c from Order c where c.name like :search")
                .setParameter("search", search.trim() + "%")
                .getResultList();
    }

    public List<Order> findByOrder(String name, String whom, String whom_from, String status) {
        return emf.createQuery(
                "select c from Order c where c.name = :name and c.whom = :whom and c.whom_from = :whom_from and c.status = :status")
                .setParameter("name", name)
                .setParameter("whom", whom)
                .setParameter("whom_from", whom_from)
                .setParameter("status", status)
                .getResultList();
    }
}
