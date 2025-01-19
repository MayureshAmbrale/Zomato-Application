package com.zomatoApp.ZomatoApp.repository;

import com.zomatoApp.ZomatoApp.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
