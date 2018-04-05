package ru.eshop.orderWebService;


import ru.eshop.model.CustomerOrder;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;


public interface OrderWebService {


    List<CustomerOrder> getAllOrders();


      CustomerOrder getOrderDetails(Long orderId);



     String setTrack(CustomerOrder order);
}
