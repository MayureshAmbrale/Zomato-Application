package com.zomatoApp.ZomatoApp.entity;

import com.zomatoApp.ZomatoApp.dto.OrderDto;
import com.zomatoApp.ZomatoApp.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "customer")
    private List<Order> order;



}
