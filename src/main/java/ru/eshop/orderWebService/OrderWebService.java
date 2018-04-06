package ru.eshop.orderWebService;


import ru.eshop.model.CustomerOrder;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.ResponseWrapper;
import java.util.List;
//@Path("/restServicePath")
@WebService(name = "SoapRestWS")
public interface OrderWebService {


  //  @WebMethod

   // List<CustomerOrder> getAllOrders();


  //  CustomerOrder getOrderDetails(Long orderId);


  //  String setTrack(CustomerOrder order);


//    @GET
//    @Path("/getPresidentsByName")
//    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//   // @WebMethod(exclude=true)    //Rest-ONLY - should not be available to JAX-WS web services
//    public Response getPresidentsByNameRest() ;

    //SOAP/WSDL only method version of getPresidentsRest()
    @WebMethod
//    @ResponseWrapper()  //Handles List return types better (?)
//    public @XmlElement
    List<CustomerOrder> getPresidentsByName() ;

}
