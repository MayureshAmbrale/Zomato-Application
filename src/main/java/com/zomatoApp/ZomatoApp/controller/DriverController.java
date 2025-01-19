package com.zomatoApp.ZomatoApp.controller;

import com.zomatoApp.ZomatoApp.dto.DeliveryDto;
import com.zomatoApp.ZomatoApp.dto.DriverDto;
import com.zomatoApp.ZomatoApp.dto.UserDto;
import com.zomatoApp.ZomatoApp.service.DeliveryService;
import com.zomatoApp.ZomatoApp.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("driver")
@RequiredArgsConstructor

public class DriverController {

    private final DriverService driverService;
    private final DeliveryService deliveryService;

    @PostMapping("onboard/{userId}")
    public ResponseEntity<DriverDto> onboardDriver(@PathVariable Long userId, @RequestBody DriverDto driverDto)
    {
        return ResponseEntity.ok(driverService.createDriver(userId,driverDto));
    }
    @PostMapping("accept/{orderId}")
    public ResponseEntity<DeliveryDto> acceptDelivery(@PathVariable Long orderId)
    {
        return ResponseEntity.ok(deliveryService.acceptDelivery(orderId));
    }
    @PostMapping("end/{orderId}")
    public ResponseEntity<DeliveryDto> endDelivery(@PathVariable Long deliveryId)
    {
        return ResponseEntity.ok(deliveryService.endDelivery(deliveryId));
    }


}
