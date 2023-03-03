package com.parkingCloud.cloudparking.service;

import com.parkingCloud.cloudparking.exception.ParkingNotFoundException;
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

    public Parking findById(String id) {
        Parking parking = parkingMap.get(id);
        if(parking == null){
            throw new ParkingNotFoundException(id);
        }
        return parking;
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());

        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;

    }

    public void delete(String id) {
        findById(id);
        parkingMap.remove(id);
    }

    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parking.setModel(parkingCreate.getModel());
        parkingMap.replace(id, parking);
        return parking;
    }
}
