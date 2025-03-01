package com.carwash.S.I_car_wash.service.serviceImpl;

import com.carwash.S.I_car_wash.repository.AppointmentRepository;
import com.carwash.S.I_car_wash.Entity.Appointment;
import com.carwash.S.I_car_wash.Entity.User;
import com.carwash.S.I_car_wash.dto.AppointmentDTO;
import com.carwash.S.I_car_wash.repository.UserRepository;
import com.carwash.S.I_car_wash.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Appointment createAppointment(AppointmentDTO appointmentDTO) {

        Optional<User> userOptional = userRepository.findById(appointmentDTO.getUserId());

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found with ID: " + appointmentDTO.getUserId());
        }

        User user = userOptional.get();


        Appointment appointment = new Appointment();
        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
        appointment.setVehicleType(appointmentDTO.getVehicleType());
        appointment.setServiceType(appointmentDTO.getServiceType());
        appointment.setUser(user);


        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAppointments() {
        return List.of();
    }

    @Override
    public boolean deleteAppointment(Long appointmentId) {
        return false;
    }

    @Override
    public Appointment updateAppointment(Long appointmentId, AppointmentDTO appointmentDTO) {
        return null;
    }
}
