package model.dao;

import model.Addressbook;

import java.util.Collection;
import java.util.List;

public interface AddressbookDao {

    void add(Addressbook entity);

    void delete(Addressbook entity);

    Collection<Addressbook> getUsers(String search);

    public List findByAddressbook(String firstname);

}
