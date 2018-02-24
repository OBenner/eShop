package ru.eshop.service;

import ru.eshop.model.BillingAddress;
import ru.eshop.model.PaymentInfo;
import ru.eshop.model.ShippingAddress;
import ru.eshop.model.User;

public interface UserInfoService {
    User getUserInfo();


    PaymentInfo addPaymentInfo(PaymentInfo paymentInfo);

    PaymentInfo updatePaymentInfo(PaymentInfo paymentInfo);

    ShippingAddress addShippingAddress(ShippingAddress shippingAddress);

    ShippingAddress updateShippingAddress(ShippingAddress shippingAddress);

    BillingAddress addBillingAddress(BillingAddress billingAddress);

    BillingAddress updateBillingAddress(BillingAddress billingAddress);


}
