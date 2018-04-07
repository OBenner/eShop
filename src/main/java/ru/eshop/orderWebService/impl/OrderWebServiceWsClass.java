package ru.eshop.orderWebService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.eshop.dao.OrderDao;
import ru.eshop.model.CustomerOrder;
import ru.eshop.model.OrderInfo;
import ru.eshop.orderWebService.OrderWebService;
import ru.eshop.service.UserInfoService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;


@WebService
@Service("serviceBean")
public class OrderWebServiceWsClass implements OrderWebService {
    @Autowired
    OrderDao orderDao;

//    @GET
//    @Path("/orders")
//    @WebMethod
//    public Response getOrders(){
//        return Response.status(200).type(MediaType.APPLICATION_JSON_TYPE).entity(orderWebService.getAllOrders()).build();
//    }

//    @GET
//    @WebMethod(exclude = true)
//    public Response getPresidentsByNameRest() {
//        return Response.status(200).type(MediaType.APPLICATION_JSON_TYPE).entity(orderWebService.getAllUserOrders()).build();
//    }


    public List<OrderInfo> getNewOrderByInfo() {
        List<OrderInfo> orderInfoList =orderDao.getNewCustomerOrder();
        if (orderInfoList==null){
            return null;
        }
        return orderInfoList;
    }


    public OrderInfo setTrackCode(long orderId,String code) throws IOException {
        CustomerOrder customerOrder = orderDao.getOrderByOrderId(orderId);
        OrderInfo orderInfo =customerOrder.getOrderInfo();
        if (orderInfo.getOrderCondition().equals("Sent")){
            throw new IOException("Exception, product already sent");
        }
        orderInfo.setTrackCode(code);
        orderInfo.setOrderCondition("Sent");
        return orderDao.createOrderInfo(orderInfo);
    }
}
