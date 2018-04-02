package ru.eshop.orderWebService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.eshop.dao.OrderDao;
import ru.eshop.model.CustomerOrder;
import ru.eshop.orderWebService.OrderWebService;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.eshop.orderWebService.OrderWebService")
public class OrderWebServiceImpl implements OrderWebService {

    @Autowired
    private OrderDao orderDao;

    public List<CustomerOrder> getAllOrders() {
        return orderDao.getAllUserOrders();
    }

    public CustomerOrder getOrderDetails(Long orderId) {
        return null;
    }

    public String setTrack(CustomerOrder order) {
        return null;
    }
}
