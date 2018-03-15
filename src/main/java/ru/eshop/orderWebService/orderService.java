package ru.eshop.orderWebService;


import ru.eshop.model.CustomerOrder;

import javax.jws.WebService;

@WebService
public interface orderService {

    String orderStatus(CustomerOrder customerOrder);
}
