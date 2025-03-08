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
        serviceEntity.setServiceId(serviceDTO.getServiceId());
        serviceEntity.setPrice(serviceDTO.getPrice());

//        // Fetch the Appointment entity using the appointmentId from the DTO
//        Appointment appointment = appointmentRepository.findById(serviceDTO.getAppointmentId())
//                .orElseThrow(() -> new RuntimeException("Appointment not found"));
//
//        // Set the appointment in the serviceEntity
//        serviceEntity.setAppointment(appointment);
//
//        // Print the service names (for debugging purposes)


        // Save the ServiceEntity
        return serviceRepository.save(serviceEntity);
    }



    @Override
    public List<ServiceEntity> getAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public boolean deleteService(Long serviceId) {
        try {
            serviceRepository.deleteById(serviceId);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public ServiceEntity updateService(Long serviceId, ServiceDTO serviceDTO) {
        ServiceEntity service=serviceRepository.findById(serviceId).orElseThrow(()->(
                new RuntimeException("Service Not Found")
                ));

        service.setServiceType(serviceDTO.getServiceType());
        service.setPrice(serviceDTO.getPrice());
        return serviceRepository.save(service);
    }
}
