package com.zomatoApp.ZomatoApp.service;

import com.zomatoApp.ZomatoApp.dto.CustomerDto;
import com.zomatoApp.ZomatoApp.dto.PaymentDto;
import com.zomatoApp.ZomatoApp.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentService {
    PaymentDto makePayment(Order orderId);
    PaymentDto cancelPayment(Order orderId);
    Page<PaymentDto> myAllPayments(CustomerDto customerId, Pageable pageRequest);
 }
