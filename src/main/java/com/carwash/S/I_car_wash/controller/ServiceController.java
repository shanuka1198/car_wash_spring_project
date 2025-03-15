package com.carwash.S.I_car_wash.controller;

import com.carwash.S.I_car_wash.Entity.ServiceEntity;
import com.carwash.S.I_car_wash.dto.ServiceDTO;
import com.carwash.S.I_car_wash.dto.ServiceResponseDTO;
import com.carwash.S.I_car_wash.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ServiceEntity createService(@RequestBody ServiceDTO serviceDTO){
        return serviceService.createService(serviceDTO);
    }

    @GetMapping
    public List<ServiceResponseDTO> getAllService(){
        return serviceService.getAllService();
    }


    @DeleteMapping("/{serviceId}")
    public boolean deleteService(@PathVariable Long serviceId){
        return serviceService.deleteService(serviceId);
    }

    @PutMapping("/{serviceId}")
    public ServiceEntity updateService(@PathVariable Long serviceId,@RequestBody ServiceDTO serviceDTO){
        return serviceService.updateService(serviceId,serviceDTO);
    }

}
