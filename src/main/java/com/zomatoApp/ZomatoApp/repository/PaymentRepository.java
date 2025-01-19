package com.zomatoApp.ZomatoApp.repository;

import com.zomatoApp.ZomatoApp.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
