package ru.eshop.service;

import ru.eshop.model.*;

import java.util.List;

public interface UserInfoService {


    User getUserInfo(String email);

    User addPaymentInfo(String email, PaymentInfo paymentInfo);

    User updatePaymentInfo(PaymentInfo paymentInfo);

    User addShippingAddress(String email, ShippingAddress shippingAddress);

    User updateShippingAddress(ShippingAddress shippingAddress);

    User addBillingAddress(String email, BillingAddress billingAddress);

    User updateBillingAddress(BillingAddress billingAddress);

    CustomerOrder createOrder(String email);

    List<CustomerOrder> getAllUserOrders(String email);
}
