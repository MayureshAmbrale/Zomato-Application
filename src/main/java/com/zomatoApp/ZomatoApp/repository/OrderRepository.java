package com.zomatoApp.ZomatoApp.repository;

import com.zomatoApp.ZomatoApp.entity.Customer;
import com.zomatoApp.ZomatoApp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


//    @Query(value = "SELECT * FROM order_for WHERE customer_id = :customerId",nativeQuery = true)
    List<Order> findByCustomer(Customer customer);
}
