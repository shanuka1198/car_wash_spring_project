package com.carwash.S.I_car_wash.controller;

import com.carwash.S.I_car_wash.Entity.Vehicles;
import com.carwash.S.I_car_wash.dto.VehicleDTO;
import com.carwash.S.I_car_wash.dto.VehicleResponseDTO;
import com.carwash.S.I_car_wash.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public Vehicles createVehicles(@RequestBody VehicleDTO vehicleDTO){
        return vehicleService.createVehicle(vehicleDTO);
    }

    @GetMapping
    public List<VehicleResponseDTO>getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

    @DeleteMapping("/{vehicleId}")
    public boolean deleteVehicle(@PathVariable Long vehicleId){
        return vehicleService.deleteVehicle(vehicleId);
    }
}
