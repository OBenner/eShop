package ru.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshop.dao.CartDao;
import ru.eshop.dao.ProductDao;
import ru.eshop.dao.UserDao;
import ru.eshop.model.Cart;
import ru.eshop.model.CartItem;
import ru.eshop.model.Product;
import ru.eshop.model.User;
import ru.eshop.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Transactional
    public Cart removeProductFromCart(String userEmail, Long itemId) {
        User user = userDao.getUserByEmail(userEmail);
        Cart cart = user.getCart();
        CartItem toDelete = null;
        for (CartItem cartItem : cart.getItems()) {
            if (cartItem.getProduct().getProductId().equals(itemId)) {
                toDelete = cartItem;
            }
        }
        if (toDelete != null) {
            cart.getItems().remove(toDelete);
        }
        return new Cart(cartDao.update(cart));
    }

    @Transactional
    public Cart getCart(String userEmail) {
        User user = userDao.getUserByEmail(userEmail);
        Cart cart = new Cart(user.getCart());
       return cart;
    }
    @Transactional
    public Cart addProductToCart(String userEmail, Long itemId, Integer quantity) {
        User user = userDao.getUserByEmail(userEmail);
        Cart cart = user.getCart();
        if (user.getCart() == null) {
            cart = new Cart();
            cart.setUser(user);
        }
        Product item = productDao.getProductById(itemId);

        boolean itemAlreadyExists = false;

        for (CartItem commerceItemEntity : cart.getItems()) {
            if (commerceItemEntity.getProduct().equals(item)) {
                commerceItemEntity.setQuantity(commerceItemEntity.getQuantity() + quantity);
                itemAlreadyExists = true;
            }
        }

        if (!itemAlreadyExists) {
            CartItem commerceItemEntity = new CartItem();
            commerceItemEntity.setQuantity(quantity);
            commerceItemEntity.setProduct(item);
            commerceItemEntity.setCart(cart);
            cart.getItems().add(commerceItemEntity);
        }

        return new Cart(cartDao.update(cart));
    }

    public Cart update(Long itemId, Integer quantity) {
        return null;
    }

    public Cart getCartById(Long id) {
        return cartDao.findById(id);
    }
}
