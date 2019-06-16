package controllers;

import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.OrderService;

import java.util.Collection;


@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<Order> getOrders(String search) {
        return orderService.getOrders(search);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ExtResult setOrder(@RequestBody Order order) {
        return new ExtResult(orderService.add(order), order);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteOrder(@RequestBody Order order) {
        orderService.delete(order);
        return "delete";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateOrder(@RequestBody Order order) {
        orderService.update(order);
        return "update";
    }
}
