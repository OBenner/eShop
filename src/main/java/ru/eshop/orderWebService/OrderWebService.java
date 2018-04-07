package ru.eshop.orderWebService;


import ru.eshop.model.CustomerOrder;
import ru.eshop.model.OrderInfo;

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
import java.io.IOException;
import java.util.List;

/**
 * The interface Order web service.
 */
//@Path("/restServicePath")
@WebService(name = "SoapRestWS")
public interface OrderWebService {


//    @GET
//    @Path("/getPresidentsByName")
//    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//   // @WebMethod(exclude=true)    //Rest-ONLY - should not be available to JAX-WS web services
//    public Response getPresidentsByNameRest() ;


    /**
     * Gets new order by info.
     *
     * @return the new order by info
     */
    @WebMethod
    List<OrderInfo> getNewOrderByInfo();


    /**
     * Sets track code.
     *
     * @param OrderId the order id
     * @param code    the code
     * @return the track code
     * @throws IOException the io exception
     */
    @WebMethod
    OrderInfo setTrackCode(long OrderId,String code) throws IOException;

}
