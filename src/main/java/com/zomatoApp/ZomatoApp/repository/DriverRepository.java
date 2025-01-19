package com.zomatoApp.ZomatoApp.repository;

import com.zomatoApp.ZomatoApp.dto.OrderDto;
import com.zomatoApp.ZomatoApp.dto.PointDto;
import com.zomatoApp.ZomatoApp.entity.Customer;
import com.zomatoApp.ZomatoApp.entity.Driver;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {
//    @Query(value = "SELECT d.*, ST_Distance(d.current_location, :pickupLocation) AS distance " +
//            "FROM driver d " +
//            "WHERE d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000) " +
//            "ORDER BY distance " +
//            "LIMIT 10", nativeQuery = true)

    @Query(value = "SELECT D.*, ST_Distance(D.current_location, :point) AS distance " +
            "FROM DRIVER D "+
            "WHERE D.isActive = true and ST_DWithin(D.current_location, :point,10000) "+
            "ORDER BY distance "+
            "LIMIT 10 ",nativeQuery = true
    )
    List<Driver> findNearestDriver(Point point);
}
