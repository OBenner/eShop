package ru.eshop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eshop.dao.OrderDao;
import ru.eshop.model.CartItem;
import ru.eshop.model.CustomerOrder;
import ru.eshop.model.OrderItem;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class OrderDaoImpl implements OrderDao{
    @Autowired
    private EntityManager entityManager;

    public OrderItem createOrderItem(CartItem cartItem) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(cartItem.getProduct());
        orderItem.setQuantity(cartItem.getQuantity());

        return entityManager.merge(orderItem) ;
    }

    public List<CustomerOrder> getAllUserOrders() {

        return entityManager.createQuery("select i from CustomerOrder i", CustomerOrder.class).getResultList();
    }


}
