package com.zomatoApp.ZomatoApp.service.Impl;

import com.zomatoApp.ZomatoApp.dto.DeliveryDto;
import com.zomatoApp.ZomatoApp.dto.PaymentDto;
import com.zomatoApp.ZomatoApp.entity.Delivery;
import com.zomatoApp.ZomatoApp.entity.Driver;
import com.zomatoApp.ZomatoApp.entity.Order;
import com.zomatoApp.ZomatoApp.enums.DeliveryStatus;
import com.zomatoApp.ZomatoApp.repository.DeliveryRepository;
import com.zomatoApp.ZomatoApp.repository.DriverRepository;
import com.zomatoApp.ZomatoApp.repository.OrderRepository;
import com.zomatoApp.ZomatoApp.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {
    private final DriverRepository driverRepository;
    private final DeliveryRepository deliveryRepository;
    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;
    @Override
    public DeliveryDto acceptDelivery(Long orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new NoSuchElementException("No order with id "+orderId));

        List<Driver> drivers = driverRepository.findNearestDriver(order.getPoint());
        Driver driver = drivers.stream()
                .findFirst()
                .get();
        Delivery newdelivery = new Delivery();
        newdelivery.setDriver(driver);
        newdelivery.setOrder(List.of(order));
        newdelivery.setDeliveryStatus(DeliveryStatus.ON_THE_WAY);
        newdelivery.setStartedAt(LocalDateTime.now());

        Delivery savedDelivery = deliveryRepository.save(newdelivery);


        return modelMapper.map(savedDelivery,DeliveryDto.class);
    }



    @Override
    public DeliveryDto endDelivery(Long deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId).orElseThrow(() -> new NoSuchElementException("No delivery with id "+deliveryId));
        delivery.setEndedAt(LocalDateTime.now());
        Delivery savedDelivery = deliveryRepository.save(delivery);
        return modelMapper.map(savedDelivery,DeliveryDto.class);
    }

    @Override
    public PaymentDto acceptPaymentCOD(Delivery deliveryId) {
        return null;
    }
}
