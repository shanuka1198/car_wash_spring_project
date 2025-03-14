package com.carwash.S.I_car_wash.service.serviceImpl;

import com.carwash.S.I_car_wash.Entity.*;
import com.carwash.S.I_car_wash.dto.AppointmentResponseDTO;
import com.carwash.S.I_car_wash.repository.AppointmentRepository;
import com.carwash.S.I_car_wash.dto.AppointmentDTO;
import com.carwash.S.I_car_wash.repository.ServiceRepository;
import com.carwash.S.I_car_wash.repository.UserRepository;
import com.carwash.S.I_car_wash.repository.VehicleRepository;
import com.carwash.S.I_car_wash.service.AppointmentService;

import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class AppointmentServiceImpl implements AppointmentService {


    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;
    private final VehicleRepository vehicleRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, UserRepository userRepository, ServiceRepository serviceRepository, VehicleRepository vehicleRepository) {
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
        this.serviceRepository = serviceRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Appointment createAppointment(AppointmentDTO appointmentDTO) {
        // Validate input
        if (appointmentDTO.getUserId() == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        if (appointmentDTO.getServiceId() == null) {
            throw new IllegalArgumentException("Service ID cannot be null");
        }
        if (appointmentDTO.getVehicleId() == null) {
            throw new IllegalArgumentException("Vehicle ID cannot be null");
        }

        // Fetch related entities
        UserEntity user = userRepository.findById(appointmentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + appointmentDTO.getUserId()));

        ServiceEntity service = serviceRepository.findById(appointmentDTO.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found with ID: " + appointmentDTO.getServiceId()));

        Vehicles vehicle = vehicleRepository.findById(appointmentDTO.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found with ID: " + appointmentDTO.getVehicleId()));

        Double totalFee= (appointmentDTO.getServiceFee()*appointmentDTO.getDiscount())/100;

        // Create and save appointment
        Appointment appointment = new Appointment();
        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
        appointment.setVehicle(vehicle);
        appointment.setUser(user);
        appointment.setService(service);
        appointment.setNote(appointmentDTO.getNote());
        appointment.setServiceFee(appointmentDTO.getServiceFee());
        appointment.setDiscount(appointmentDTO.getDiscount());
        appointment.setTotalFee(appointment.getServiceFee()-totalFee);

        return appointmentRepository.save(appointment);
    }



    @Override
    public List<AppointmentResponseDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream().map(AppointmentResponseDTO::new).toList();
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

        // Validate input
        if (appointmentDTO.getUserId() == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        if (appointmentDTO.getServiceId() == null) {
            throw new IllegalArgumentException("Service ID cannot be null");
        }
        if (appointmentDTO.getVehicleId() == null) {
            throw new IllegalArgumentException("Vehicle ID cannot be null");
        }

        // Fetch and update the vehicle
        Vehicles vehicle = vehicleRepository.findById(appointmentDTO.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found with ID: " + appointmentDTO.getVehicleId()));
        appointment.setVehicle(vehicle);

        // Fetch and update the user
        UserEntity user = userRepository.findById(appointmentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + appointmentDTO.getUserId()));
        appointment.setUser(user);

        // Fetch and update the service
        ServiceEntity service = serviceRepository.findById(appointmentDTO.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found with ID: " + appointmentDTO.getServiceId()));
        appointment.setService(service);

        Double totalFee= (appointmentDTO.getServiceFee()*appointmentDTO.getDiscount())/100;


        // Update the appointment date and time
        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
        appointment.setNote(appointmentDTO.getNote());
        appointment.setServiceFee(appointmentDTO.getServiceFee());
        appointment.setDiscount(appointmentDTO.getDiscount());
        appointment.setTotalFee(appointment.getServiceFee()-totalFee);
        // Save and return the updated appointment
        return appointmentRepository.save(appointment);
    }

}
