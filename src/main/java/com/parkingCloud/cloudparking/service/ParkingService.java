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

        var id1 = getUUID();
        Parking parking1 = new Parking(id1, "785btd", "MT", "celta", "verde",LocalDateTime.now());
        parkingMap.put(id1, parking1);
    }

    private static String  getUUID(){
        return UUID.randomUUID().toString().replace("-", "");

    }

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    public Parking findById(String id) {
        return parkingMap.get(id);
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());

        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;

    }
}
