package com.carwash.S.I_car_wash.repository;

import com.carwash.S.I_car_wash.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
