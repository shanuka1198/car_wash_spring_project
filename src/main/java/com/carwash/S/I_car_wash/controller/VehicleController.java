package com.carwash.S.I_car_wash.controller;

import com.carwash.S.I_car_wash.Entity.Vehicles;
import com.carwash.S.I_car_wash.dto.VehicleDTO;
import com.carwash.S.I_car_wash.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public Vehicles createVehicles(@RequestBody VehicleDTO vehicleDTO){
        return vehicleService.createVehicle(vehicleDTO);
    }
}
