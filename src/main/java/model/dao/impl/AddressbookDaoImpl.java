package model.dao.impl;

import model.Addressbook;
import model.dao.AddressbookDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;


public class AddressbookDaoImpl implements AddressbookDao {

    @PersistenceContext
    private EntityManager emf;

    @Override
    public void add(Addressbook addressbook) {
        emf.persist(addressbook);
    }

    @Override
    public void delete(Addressbook addressbook) {
        emf.remove(emf.getReference(Addressbook.class, addressbook.getId()));
    }

    @Override
    public Collection<Addressbook> getUsers(String search) {
        if (null == search || search.trim().isEmpty()) {
            return emf.createQuery(
                    "select c from Addressbook c")
                    .getResultList();
        }
        return emf.createQuery(
                "select c from Addressbook c where c.name like :search")
                .setParameter("search", search.trim() + "%")
                .getResultList();
    }

    public List<Addressbook> findByAddressbook(String firstname) {
        return emf.createQuery(
                "select c from Addressbook c where c.firstname = :firstname")
                .setParameter("firstname", firstname)
                .getResultList();
    }
}
