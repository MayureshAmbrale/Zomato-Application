package com.zomatoApp.ZomatoApp.service;

import com.zomatoApp.ZomatoApp.dto.DeliveryDto;
import com.zomatoApp.ZomatoApp.dto.DriverDto;
import com.zomatoApp.ZomatoApp.dto.OrderDto;
import com.zomatoApp.ZomatoApp.dto.PaymentDto;
import com.zomatoApp.ZomatoApp.entity.Delivery;
import com.zomatoApp.ZomatoApp.entity.Order;

public interface DeliveryService {


    DeliveryDto acceptDelivery(Long orderId);

    DeliveryDto endDelivery(Long deliveryId);

    PaymentDto acceptPaymentCOD(Delivery deliveryId);
}
