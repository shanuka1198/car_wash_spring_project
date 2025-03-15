package com.carwash.S.I_car_wash.service;


import com.carwash.S.I_car_wash.Entity.ServiceEntity;
import com.carwash.S.I_car_wash.dto.ServiceDTO;
import com.carwash.S.I_car_wash.dto.ServiceResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceService {

     ServiceEntity createService(ServiceDTO serviceDTO);
     List<ServiceResponseDTO> getAllService();
     boolean deleteService(Long serviceId);
     ServiceEntity updateService(Long serviceId,ServiceDTO serviceDTO);

}
