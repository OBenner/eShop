package ru.eshop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.eshop.model.User;
import ru.eshop.service.UserService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


/**
 * The type User service controller.
 */
@RestController
@RequestMapping("users")
public class UserServiceController {

    @Autowired
    private UserService userService;


    /**
     * Create user.
     *
     * @param user the user
     * @return the user
     */
    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user){

        return userService.addUser(user);
    }








}
