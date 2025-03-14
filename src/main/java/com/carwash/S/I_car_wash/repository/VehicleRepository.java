package com.carwash.S.I_car_wash.repository;


import com.carwash.S.I_car_wash.Entity.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicles,Long> {
}
