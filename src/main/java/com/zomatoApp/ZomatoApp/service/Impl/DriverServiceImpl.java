package com.zomatoApp.ZomatoApp.service.Impl;

import com.zomatoApp.ZomatoApp.dto.DeliveryDto;
import com.zomatoApp.ZomatoApp.dto.DriverDto;
import com.zomatoApp.ZomatoApp.entity.Delivery;
import com.zomatoApp.ZomatoApp.entity.Driver;
import com.zomatoApp.ZomatoApp.entity.Order;
import com.zomatoApp.ZomatoApp.entity.User;
import com.zomatoApp.ZomatoApp.enums.Role;
import com.zomatoApp.ZomatoApp.repository.DriverRepository;
import com.zomatoApp.ZomatoApp.repository.UserRepository;
import com.zomatoApp.ZomatoApp.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    private final ModelMapper modelMapper;
    private final DriverRepository driverRepository;
    private final UserRepository userRepository;



    @Override
    public DriverDto createDriver(Long userId,DriverDto driverDto) {
        User user = userRepository.findById(userId).orElseThrow(()->new NoSuchElementException("No user with id :"+userId));
        user.setRoles(Set.of(Role.DRIVER));
        Driver driver = modelMapper.map(driverDto,Driver.class);
        driver.setUser(user);
        driver.setRating(0.0);
        driver.setIsActive(true);
        Driver savedDriver = driverRepository.save(driver);

        return modelMapper.map(savedDriver,DriverDto.class);
    }
}
