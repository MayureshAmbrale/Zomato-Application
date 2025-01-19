package com.zomatoApp.ZomatoApp.service.Impl;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.locationtech.jts.geom.Point;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class OSRMDistanceService {
    private final String BASE_URL = "http://router.project-osrm.org/route/v1/driving/";

    private double calculateDistance(Point src, Point dest)
    {
        try {
            String uri = src.getX() + "," + src.getY() + ";" + dest.getX() + "," + dest.getY();

            OSRMDto osrmDto = RestClient.builder()
                    .baseUrl(BASE_URL)
                    .build()
                    .get()
                    .uri(uri)
                    .retrieve()
                    .body(OSRMDto.class);
            return osrmDto.getRouts().get(0).getDistance() / 1000;
        }
        catch (Exception e)
        {
            throw  new RuntimeException(e.getMessage());
        }
    }
}
@Data
class OSRMDto
{
    private List<OSRMRouts> routs;
}

@Data
class OSRMRouts
{
    private Double distance;
}
