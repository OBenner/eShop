package ru.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eshop.dao.CustomerOrderDao;
import ru.eshop.model.Cart;
import ru.eshop.model.CartItem;
import ru.eshop.model.CustomerOrder;
import ru.eshop.service.CartService;
import ru.eshop.service.CustomerOrderService;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;
    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cartId) {
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem item : cartItems) {
            grandTotal += item.getTotalPrice();
        }
        return grandTotal;
    }
}
