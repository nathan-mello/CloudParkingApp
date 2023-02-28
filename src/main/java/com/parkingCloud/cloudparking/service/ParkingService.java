package com.parkingCloud.cloudparking.service;

import com.parkingCloud.cloudparking.model.Parking;
import org.springframework.core.annotation.MergedAnnotationPredicates;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static final Map<String, Parking> parkingMap = new HashMap<>();

    static {
        var id = getUUID();
        Parking parking = new Parking(id, "MS-123", "SP", "Fiat polo", "red",LocalDateTime.now());
        parkingMap.put(id, parking);
    }

    private static String  getUUID(){
        return UUID.randomUUID().toString().replace("-", "");

    }

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

}
