package controllers;

import model.Addressbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.AddressbookService;

import java.util.Collection;

@Controller
@RequestMapping("/Addressbook")
public class AddressbookController {

    @Autowired
    private AddressbookService addressbookService;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<Addressbook> getAddressbook(String search) {
        return addressbookService.getUsers(search);
    }

}
