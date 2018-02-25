package ru.eshop.service;

import ru.eshop.model.BillingAddress;
import ru.eshop.model.PaymentInfo;
import ru.eshop.model.ShippingAddress;
import ru.eshop.model.User;

public interface UserInfoService {


    User getUserInfo(String email);

    User addPaymentInfo(String email,PaymentInfo paymentInfo);

    User updatePaymentInfo(PaymentInfo paymentInfo);

    User addShippingAddress(String email,ShippingAddress shippingAddress);

    User updateShippingAddress(ShippingAddress shippingAddress);

    User addBillingAddress(String email,BillingAddress billingAddress);

    User updateBillingAddress(BillingAddress billingAddress);


}
