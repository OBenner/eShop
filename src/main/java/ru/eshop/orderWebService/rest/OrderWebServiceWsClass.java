package ru.eshop.orderWebService.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.eshop.orderWebService.OrderWebService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
public class OrderWebServiceWsClass {
 //   @Autowired
    OrderWebService orderWebService;

    @GET
    @Path("/orders")
    public Response getOrders(){
        return Response.status(200).type(MediaType.APPLICATION_JSON_TYPE).entity(orderWebService.getAllOrders()).build();
    }


    public OrderWebService getOrderWebService() {
        return orderWebService;
    }

    public void setOrderWebService(OrderWebService orderWebService) {
        this.orderWebService = orderWebService;
    }
}
