package model.dao;

import model.Status;

import java.util.Collection;
import java.util.List;

public interface StatusDao {

    void add(Status entity);

    void delete(Status entity);

    Collection<Status> getStatus(String search);

    public List findByStatus(String name);

}
