package service;

import model.Addressbook;

import java.util.Collection;



public interface AddressbookService {

    Boolean add(Addressbook addressbook);

    Collection<Addressbook> getUsers(String search);

    void delete(Addressbook addressbook);

}
