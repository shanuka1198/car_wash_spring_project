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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
        // userId හෝ serviceId null ද?
        if (appointmentDTO.getUserId() == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        if (appointmentDTO.getServiceId() == null) {
            throw new IllegalArgumentException("Service ID cannot be null");
        }

        // UserEntity ID එක මත ලබා ගැනීම
        UserEntity user = userRepository.findById(appointmentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + appointmentDTO.getUserId()));

        // ServiceEntity ID එක මත ලබා ගැනීම
        ServiceEntity service = serviceRepository.findById(appointmentDTO.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found with ID: " + appointmentDTO.getServiceId()));

        // Appointment entity එකක් සාදීම
        Appointment appointment = new Appointment();
        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
        // VehicleType enum එක String එකෙන් පරිවර්තනය කිරීම
        appointment.setVehicleType(Appointment.VehicleType.valueOf(appointmentDTO.getVehicleType().toUpperCase()));
        appointment.setUser(user); // UserEntity එක සම්බන්ධ කිරීම
        appointment.setService(service); // ServiceEntity එක සම්බන්ධ කිරීම

        // Appointment Entity එක සුරක්ෂිත කිරීම හා ප්‍රතිඵලය返 ගැන්වීම
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
    public Appointment updateAppointment(Long appointmentId, AppointmentDTO appointmentDTO) throws Exception {
        // Retrieve the appointment to be updated by ID
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + appointmentId));

        // Update the basic fields of the appointment
        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
        appointment.setVehicleType(Appointment.VehicleType.valueOf(appointmentDTO.getVehicleType().toUpperCase())); // Convert String to Enum

        // Retrieve the associated user (you can assume the user exists, as the appointmentDTO includes userId)
        UserEntity user = userRepository.findById(appointmentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + appointmentDTO.getUserId()));
        appointment.setUser(user);  // Update user if needed (if user can change, or leave as is if it's fixed)

        // Retrieve the associated service (now the appointment is linked to a single service entity)
        ServiceEntity service = serviceRepository.findById(appointmentDTO.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found with id: " + appointmentDTO.getServiceId()));

        // Only set the new service to the appointment (don't update the service type)
        appointment.setService(service);

        // Save and return the updated appointment
        return appointmentRepository.save(appointment);
    }







}
