package ru.eshop.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.eshop.model.Cart;
import ru.eshop.service.CartService;

/**
 * The type Cart controller.
 */
@RestController
@RequestMapping("/cart")
public class CartController  extends  BaseController{

@Autowired
private CartService cartService;

    /**
     * Add product to cart cart.
     *
     * @param productId the product id
     * @param quantity  the quantity
     * @return the cart
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cart addProductToCart(@RequestParam("productId") Long productId, @RequestParam("quantity") Integer quantity) {
        return cartService.addProductToCart(getPrincipal(), productId, quantity);
    }

    /**
     * Remove item from cart cart.
     *
     * @param productId the product id
     * @return the cart
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public Cart removeItemFromCart(@RequestParam("productId") Long productId) {
        return cartService.removeProductFromCart(getPrincipal(), productId);
    }

    /**
     * Gets cart.
     *
     * @return the cart
     */
    @RequestMapping(method = RequestMethod.GET)
    public Cart getCart() {
        return cartService.getCart(getPrincipal());
    }
}
