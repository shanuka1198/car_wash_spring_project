package com.carwash.S.I_car_wash.repository;

import com.carwash.S.I_car_wash.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
