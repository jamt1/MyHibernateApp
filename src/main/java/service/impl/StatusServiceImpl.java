package service.impl;

import model.Status;
import model.dao.StatusDao;
import org.springframework.transaction.annotation.Transactional;
import service.StatusService;

import java.util.Collection;
import java.util.List;


public class StatusServiceImpl implements StatusService {

    private StatusDao statusDao;

    public StatusDao getStatusDao() {
        return statusDao;
    }

    public void setStatusDao(StatusDao StatusDao) {
        this.statusDao = StatusDao;
    }

    @Transactional
    @Override
    public Boolean add(Status entity) {
        List<Status> duplicate = statusDao.findByStatus(entity.getName());
        if (duplicate.isEmpty()) {
            statusDao.add(entity);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public Collection<Status> getStatus(String search) {
        return statusDao.getStatus(search);
    }

    @Transactional
    @Override
    public void delete(Status entity) {
        statusDao.delete(entity);
    }

}
