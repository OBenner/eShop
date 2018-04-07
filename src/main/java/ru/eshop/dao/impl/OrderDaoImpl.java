package ru.eshop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshop.dao.OrderDao;
import ru.eshop.model.*;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * The type Order dao.
 */
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

    public CustomerOrder getOrderByOrderId(Long orderId) {
        return entityManager.find(CustomerOrder.class, orderId);
    }

    public List<OrderInfo> getNewCustomerOrder() {
        return entityManager.createQuery(
                "SELECT c FROM OrderInfo c WHERE c.orderCondition LIKE :con")
                .setParameter("con", "Create")
                .getResultList();
    }

    @Transactional
    public OrderInfo createOrderInfo(OrderInfo orderInfo){
        return entityManager.merge(orderInfo);
    }


}
