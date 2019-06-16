package model.dao.impl;

import model.Status;
import model.dao.StatusDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;


public class StatusDaoImpl implements StatusDao {

    @PersistenceContext
    private EntityManager emf;

    @Override
    public void add(Status status) {
        emf.persist(status);
    }

    @Override
    public void delete(Status status) {
        emf.remove(emf.getReference(Status.class, status.getId()));
    }

    @Override
    public Collection<Status> getStatus(String search) {
        if (null == search || search.trim().isEmpty()) {
            return emf.createQuery(
                    "select c from Status c")
                    .getResultList();
        }
        return emf.createQuery(
                "select c from Status c where c.name like :search")
                .setParameter("search", search.trim() + "%")
                .getResultList();
    }

    public List<Status> findByStatus(String name) {
        return emf.createQuery(
                "select c from Status c where c.name = :name")
                .setParameter("name", name)
                .getResultList();
    }
}
