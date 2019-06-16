package controllers;

import model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.StatusService;

import java.util.Collection;

@Controller
@RequestMapping("/orderStatus")
public class StatusController {

    @Autowired
    private StatusService statusService;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<Status> getStatus(String search) {
        return statusService.getStatus(search);
    }

}
