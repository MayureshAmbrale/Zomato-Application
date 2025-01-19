package com.zomatoApp.ZomatoApp.service;

import com.zomatoApp.ZomatoApp.dto.DeliveryDto;
import com.zomatoApp.ZomatoApp.dto.DriverDto;
import com.zomatoApp.ZomatoApp.entity.Delivery;
import com.zomatoApp.ZomatoApp.entity.Order;

public interface DriverService {



    DriverDto createDriver(Long userId,DriverDto driverDto);

}
