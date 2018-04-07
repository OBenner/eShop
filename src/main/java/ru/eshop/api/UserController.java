package ru.eshop.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import ru.eshop.model.*;
import ru.eshop.service.OrderService;
import ru.eshop.service.UserInfoService;
import ru.eshop.service.UserService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;
    /**
     * Add shipping address user.
     *
     * @param shippingAddress the shipping address
     * @return the user
     */
    @RequestMapping(value = "shippingAddress", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addShippingAddress(@RequestBody ShippingAddress shippingAddress) {
        return userInfoService.addShippingAddress(getPrincipal(), shippingAddress);
    }


    /**
     * Add billing address user.
     *
     * @param billingAddress the billing address
     * @return the user
     */
    @RequestMapping(value = "billingAddress", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addBillingAddress(@RequestBody BillingAddress billingAddress) {
        return userInfoService.addBillingAddress(getPrincipal(), billingAddress);
    }

    @RequestMapping(value = "UptBillingAddress", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User uptBillingAddress(@RequestParam("id") Long id,@RequestBody BillingAddress billingAddress) {
        return userInfoService.updateBillingAddress(getPrincipal(),id, billingAddress);
    }
    /**
     * Add payment info user.
     *
     * @param paymentInfo the payment info
     * @return the user
     */
    @RequestMapping(value = "paymentInfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addPaymentInfo(@RequestBody PaymentInfo paymentInfo) {
        return userInfoService.addPaymentInfo(getPrincipal(), paymentInfo);
    }

    /**
     * Delete user string.
     *
     * @param user the user
     * @return the string
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String deleteUser(User user) {
        userService.deleteUser(user);
        return "user delete";
    }

    /**
     * Gets user info.
     *
     * @return the user info
     */
    @RequestMapping(method = RequestMethod.GET)
    public User getUserInfo() {
        return userInfoService.getUserInfo(getPrincipal());
    }

//    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
//    public User getUserInfo(@PathVariable Long id) {
//        return userService.getUserById(id);
//    }

    /**
     * Create order customer order.
     *
     * @return the customer order
     */
    @RequestMapping(value = "checkOut", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerOrder createOrder() {
        return orderService.createOrder(getPrincipal());
    }

}
