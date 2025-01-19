package com.zomatoApp.ZomatoApp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.geo.Point;

@Entity
@Getter
@Setter
public class RequestOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    private Restaurant restaurant;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point currentLocation;

}
