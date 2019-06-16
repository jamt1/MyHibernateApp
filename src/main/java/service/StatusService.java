package service;

import model.Status;

import java.util.Collection;



public interface StatusService {

    Boolean add(Status status);

    Collection<Status> getStatus(String search);

    void delete(Status status);

}
