package com.carwash.S.I_car_wash.service.serviceImpl;

import com.carwash.S.I_car_wash.Entity.Appointment;
import com.carwash.S.I_car_wash.Entity.ServiceEntity;
import com.carwash.S.I_car_wash.dto.ServiceDTO;
import com.carwash.S.I_car_wash.repository.AppointmentRepository;
import com.carwash.S.I_car_wash.repository.ServiceRepository;
import com.carwash.S.I_car_wash.service.AppointmentService;
import com.carwash.S.I_car_wash.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {


    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public ServiceEntity createService(ServiceDTO serviceDTO) {

        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setServiceType(serviceDTO.getServiceType());
        serviceEntity.setServiceNames(serviceDTO.getServiceNames()); // Ensure this is set
        serviceEntity.setPrice(serviceDTO.getPrice());

        System.out.println(serviceEntity.getServiceNames());
        return serviceRepository.save(serviceEntity);
    }


    @Override
    public List<ServiceEntity> getAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public boolean deleteService(Long serviceId) {
        return false;
    }

    @Override
    public ServiceEntity updateService(Long serviceId, ServiceDTO serviceDTO) {
        return null;
    }
}
