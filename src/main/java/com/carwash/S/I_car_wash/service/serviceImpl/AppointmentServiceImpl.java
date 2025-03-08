package com.carwash.S.I_car_wash.service.serviceImpl;

import com.carwash.S.I_car_wash.Entity.ServiceEntity;
import com.carwash.S.I_car_wash.dto.ServiceDTO;
import com.carwash.S.I_car_wash.repository.AppointmentRepository;
import com.carwash.S.I_car_wash.Entity.Appointment;
import com.carwash.S.I_car_wash.Entity.UserEntity;
import com.carwash.S.I_car_wash.dto.AppointmentDTO;
import com.carwash.S.I_car_wash.repository.ServiceRepository;
import com.carwash.S.I_car_wash.repository.UserRepository;
import com.carwash.S.I_car_wash.service.AppointmentService;

import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class AppointmentServiceImpl implements AppointmentService {


    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, UserRepository userRepository, ServiceRepository serviceRepository) {
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Appointment createAppointment(AppointmentDTO appointmentDTO) {
        // Validate if the user ID is provided
        if (appointmentDTO.getUserId() == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }

        // Fetch the user from the repository
        UserEntity user = userRepository.findById(appointmentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + appointmentDTO.getUserId()));

        // Fetch the service from the repository using the serviceId from AppointmentDTO
        ServiceEntity service = serviceRepository.findById(appointmentDTO.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found with ID: " + appointmentDTO.getServiceId()));

        // Create a new Appointment using the AppointmentDTO
        Appointment appointment = new Appointment();
        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
        appointment.setVehicleType(Appointment.VehicleType.valueOf(appointmentDTO.getVehicleType().name())); // Convert String to Enum
        appointment.setUser(user);
        appointment.setService(service); // Set the service for this appointment

        // ⚡ Add the appointment to the service entity (One-to-Many relationship)
        service.getAppointments().add(appointment);

        // Save the appointment (Cascade will save it under the service)
        return appointmentRepository.save(appointment);
    }



    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public boolean deleteAppointment(Long appointmentId) {
        try {
            appointmentRepository.deleteById(appointmentId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Appointment updateAppointment(Long appointmentId, AppointmentDTO appointmentDTO) {
        // Fetch the existing appointment
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found with ID: " + appointmentId));

        // Update the appointment details from the AppointmentDTO
        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
        appointment.setVehicleType(Appointment.VehicleType.valueOf(appointmentDTO.getVehicleType().name())); // Convert String to Enum

        // Fetch and update the user from the repository
        UserEntity user = userRepository.findById(appointmentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + appointmentDTO.getUserId()));
        appointment.setUser(user);

        // Fetch and update the service from the repository
        ServiceEntity service = serviceRepository.findById(appointmentDTO.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found with ID: " + appointmentDTO.getServiceId()));

        // Remove the appointment from the old service (if changed)
        if (!appointment.getService().getServiceId().equals(service.getServiceId())) {
            appointment.getService().getAppointments().remove(appointment);
            service.getAppointments().add(appointment);
        }

        appointment.setService(service); // Update the service for the appointment

        // Save and return the updated appointment
        return appointmentRepository.save(appointment);
    }
}
