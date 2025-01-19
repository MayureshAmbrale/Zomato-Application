package com.zomatoApp.ZomatoApp.dto;

import com.zomatoApp.ZomatoApp.enums.DeliveryStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryDto {

    private Long id;
    private DriverDto driver;

    private OrderDto order;

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

    private PaymentDto pay;
    private DeliveryStatus deliveryStatus;
}
