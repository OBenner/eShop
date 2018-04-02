package ru.eshop.orderWebService;


import ru.eshop.model.CustomerOrder;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface OrderWebService {

    @WebMethod
   public List<CustomerOrder> getAllOrders();

    @WebMethod
  public    CustomerOrder getOrderDetails(Long orderId);


    @WebMethod
  public   String setTrack(CustomerOrder order);
}
