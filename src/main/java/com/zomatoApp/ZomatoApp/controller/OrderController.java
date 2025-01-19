package com.zomatoApp.ZomatoApp.controller;

import com.zomatoApp.ZomatoApp.dto.OrderDto;
import com.zomatoApp.ZomatoApp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {
    private final CustomerService customerService;

    @PostMapping("make")
    public ResponseEntity<OrderDto> makeOrder(@RequestBody OrderDto orderDto)
    {
        return ResponseEntity.ok(customerService.makeOrder(orderDto));
    }
    @PostMapping("allOrders")
    public ResponseEntity<List<OrderDto>> getAllMyOrders()
    {
        return ResponseEntity.ok(customerService.getMyAllOrders());
    }
    @PostMapping("cancel/{orderId}")
    public ResponseEntity<OrderDto> cancelOrder(@PathVariable Long orderId)
    {
        return ResponseEntity.ok(customerService.cancelOrder(orderId));
    }


}
