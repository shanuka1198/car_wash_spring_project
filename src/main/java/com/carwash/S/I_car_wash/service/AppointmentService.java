package com.carwash.S.I_car_wash.service;

import com.carwash.S.I_car_wash.Entity.Appointment;
import com.carwash.S.I_car_wash.dto.AppointmentResponseDTO;
import com.carwash.S.I_car_wash.dto.AppointmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {
    Appointment createAppointment(AppointmentDTO appointmentDTO);
    List<AppointmentResponseDTO> getAllAppointments();
    boolean deleteAppointment(Long appointmentId);
    Appointment updateAppointment(Long appointmentId, AppointmentDTO appointmentDTO) throws Exception;
}
