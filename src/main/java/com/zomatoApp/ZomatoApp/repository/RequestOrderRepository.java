package com.zomatoApp.ZomatoApp.repository;

import com.zomatoApp.ZomatoApp.entity.RequestOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestOrderRepository extends JpaRepository<RequestOrder , Long> {
}
