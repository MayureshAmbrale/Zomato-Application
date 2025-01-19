package com.zomatoApp.ZomatoApp.dto;

import com.zomatoApp.ZomatoApp.entity.User;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
    private Long id;

    private User user;

    private Double rating;
    private Boolean isActive;
    private PointDto currentLocation;
}
