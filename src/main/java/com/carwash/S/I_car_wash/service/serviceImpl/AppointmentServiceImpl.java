package com.carwash.S.I_car_wash.service.serviceImpl;

import com.carwash.S.I_car_wash.repository.AppointmentRepository;
import com.carwash.S.I_car_wash.Entity.Appointment;
import com.carwash.S.I_car_wash.Entity.UserEntity;
import com.carwash.S.I_car_wash.dto.AppointmentDTO;
import com.carwash.S.I_car_wash.repository.UserRepository;
import com.carwash.S.I_car_wash.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {


    private final AppointmentRepository appointmentRepository;


    private final UserRepository userRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Appointment createAppointment(AppointmentDTO appointmentDTO) {

        Optional<UserEntity> userOptional = userRepository.findById(appointmentDTO.getUserId());


        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found with ID: " + appointmentDTO.getUserId());
        }

        UserEntity user = userOptional.get();


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
