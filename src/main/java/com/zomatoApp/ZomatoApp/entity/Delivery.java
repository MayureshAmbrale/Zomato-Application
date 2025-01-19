package com.zomatoApp.ZomatoApp.entity;

import com.zomatoApp.ZomatoApp.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Driver driver;

    @OneToMany(mappedBy = "delivery",fetch = FetchType.LAZY)
    private List<Order> order;

    @CreationTimestamp
    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

    @OneToOne
    private Payment pay;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;


}
