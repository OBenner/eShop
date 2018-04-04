package ru.eshop.orderWebService;


import ru.eshop.model.CustomerOrder;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface OrderWebService {

    @WebMethod
    List<CustomerOrder> getAllOrders();

    @WebMethod
      CustomerOrder getOrderDetails(Long orderId);


    @WebMethod
     String setTrack(CustomerOrder order);
}
