package ru.eshop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.eshop.model.CustomerOrder;
import ru.eshop.model.OrderInfo;
import ru.eshop.service.OrderService;
import ru.eshop.service.UserInfoService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * The type Order controller.
 */
@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;


    @Autowired
    private OrderService orderService;

    /**
     * Get all user orders list.
     *
     * @return the list
     */
    @RequestMapping(method = RequestMethod.GET,produces = APPLICATION_JSON_VALUE)
    public List<CustomerOrder> getAllUserOrders(){
        return orderService.getAllUserOrders(getPrincipal());
    }


    /**
     * Get order info by id order info.
     *
     * @param id the id
     * @return the order info
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,value = "{id}")
    public OrderInfo getOrderInfoById(@PathVariable Long id){
        return orderService.getOrderInfoByOrderId(id);
    }

}
