package service.impl;

import model.Addressbook;
import model.dao.AddressbookDao;
import org.springframework.transaction.annotation.Transactional;
import service.AddressbookService;

import java.util.Collection;
import java.util.List;

public class AddressbookServiceImpl implements AddressbookService {

    private AddressbookDao addressbookDao;

    public AddressbookDao getAddressbookDao() {
        return addressbookDao;
    }

    public void setAddressbookDao(AddressbookDao AddressbookDao) {
        this.addressbookDao = AddressbookDao;
    }

    @Transactional
    @Override
    public Boolean add(Addressbook entity) {
        List<Addressbook> duplicate = addressbookDao.findByAddressbook(entity.getFirstname());
        if (duplicate.isEmpty()) {
            addressbookDao.add(entity);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public Collection<Addressbook> getUsers(String search) {
        return addressbookDao.getUsers(search);
    }

    @Transactional
    @Override
    public void delete(Addressbook entity) {
        addressbookDao.delete(entity);
    }

}
