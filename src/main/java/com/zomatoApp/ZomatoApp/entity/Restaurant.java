package com.zomatoApp.ZomatoApp.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import java.util.List;

@Entity
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Delivery delivery;
//    @OneToMany(mappedBy = "restaurant")
//    private List<Order> orders;
    private Double rating;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point restaurantLocation;

    private Boolean open;
}
