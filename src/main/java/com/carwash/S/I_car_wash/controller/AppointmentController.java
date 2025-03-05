package com.carwash.S.I_car_wash.controller;

import com.carwash.S.I_car_wash.Entity.Appointment;
import com.carwash.S.I_car_wash.dto.AppointmentDTO;
import com.carwash.S.I_car_wash.service.serviceImpl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentServiceImpl appointmentService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
    public Appointment createAppointment(@RequestBody AppointmentDTO appointmentDTO){
        return appointmentService.createAppointment(appointmentDTO);
    }

    @GetMapping("/all_appointment")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @DeleteMapping("/appointment/{appointmentId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
    public boolean deleteAppointment(@PathVariable Long appointmentId) {
        return appointmentService.deleteAppointment(appointmentId);
    }

    @PutMapping("/appointment/{appointmentId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
    public Appointment updateAppointment(@PathVariable Long appointmentId,@RequestBody AppointmentDTO appointmentDTO) throws Exception {
        return appointmentService.updateAppointment(appointmentId,appointmentDTO);
    }
}
