package ru.eshop.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.eshop.model.User;
import ru.eshop.model.ShippingAddress;
import ru.eshop.service.UserService;

@RestController
@RequestMapping(name = "user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "shippingInfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addShippingAddress(@RequestBody ShippingAddress shippingAddress) {
        return userService.addShippingAddress(getPrincipal(), shippingAddress);
    }

    @RequestMapping(method = RequestMethod.GET)
    public User getUserInfo(OAuth2Authentication auth) {
        return userService.getUserInfo(getPrincipal());
    }


}
