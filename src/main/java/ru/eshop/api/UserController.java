package ru.eshop.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import ru.eshop.model.*;
import ru.eshop.service.UserInfoService;
import ru.eshop.service.UserService;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "shippingAddress", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addShippingAddress(@RequestBody ShippingAddress shippingAddress) {
        return userInfoService.addShippingAddress(getPrincipal(), shippingAddress);
    }


    @RequestMapping(value = "billingAddress", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addBillingAddress(@RequestBody BillingAddress billingAddress) {
        return userInfoService.addBillingAddress(getPrincipal(), billingAddress);
    }


    @RequestMapping(value = "paymentInfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addPaymentInfo(@RequestBody PaymentInfo paymentInfo) {
        return userInfoService.addPaymentInfo(getPrincipal(), paymentInfo);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String deleteUser(User user) {
        userService.deleteUser(user);
        return "user delete";
    }

    @RequestMapping(method = RequestMethod.GET)
    public User getUserInfo(OAuth2Authentication auth) {
        return userInfoService.getUserInfo(getPrincipal());
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    public User getUserInfo(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "checkOut", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerOrder createOrder(@RequestParam("cartId") Long cartId) {

        return userInfoService.createOrder(getPrincipal(), cartId);
    }
}
