package com.zomatoApp.ZomatoApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zomatoApp.ZomatoApp.dto.CustomerDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "order_for")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne
    private Customer customer;

//    @ManyToOne
//    @JoinColumn(name = "restaurant_id")
//    @JsonIgnore
//    private Restaurant restaurant;

    private List<String> menu;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point point;

}
