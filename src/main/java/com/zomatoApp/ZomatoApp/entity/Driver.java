package com.zomatoApp.ZomatoApp.entity;

import com.zomatoApp.ZomatoApp.dto.PointDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@Setter
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private Double rating;

    private Boolean isActive;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point currentLocation;

}
