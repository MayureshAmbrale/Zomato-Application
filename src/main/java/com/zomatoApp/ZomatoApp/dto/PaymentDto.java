package com.zomatoApp.ZomatoApp.dto;

import com.zomatoApp.ZomatoApp.enums.PaymentMethod;
import com.zomatoApp.ZomatoApp.enums.PaymentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentDto {
    private Long id;
    private PaymentMethod paymentMethod;
    private Double amount;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentTime;

}
