package com.carwash.S.I_car_wash.service.serviceImpl;

import com.carwash.S.I_car_wash.Entity.*;
import com.carwash.S.I_car_wash.dto.AppointmentResponseDTO;
import com.carwash.S.I_car_wash.dto.ServiceDTO;
import com.carwash.S.I_car_wash.dto.VehicleDTO;
import com.carwash.S.I_car_wash.repository.AppointmentRepository;
import com.carwash.S.I_car_wash.dto.AppointmentDTO;
import com.carwash.S.I_car_wash.repository.ServiceRepository;
import com.carwash.S.I_car_wash.repository.UserRepository;
import com.carwash.S.I_car_wash.repository.VehicleRepository;
import com.carwash.S.I_car_wash.service.AppointmentService;

import org.springframework.stereotype.Service;


import java.util.IllegalFormatCodePointException;
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

        if (appointmentDTO.getUserId() == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        if (appointmentDTO.getServiceId() == null) {
            throw new IllegalArgumentException("Service ID cannot be null");
        }
        if (appointmentDTO.getVehicleId() == null) {
            throw new IllegalArgumentException("Vehicle ID cannot be null");
        }


        UserEntity user = userRepository.findById(appointmentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + appointmentDTO.getUserId()));

        ServiceEntity service = serviceRepository.findById(appointmentDTO.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found with ID: " + appointmentDTO.getServiceId()));

        Vehicles vehicle = vehicleRepository.findById(appointmentDTO.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found with ID: " + appointmentDTO.getVehicleId()));




        ServiceEntity service1=new ServiceEntity();
        service1.setServiceType(service.getServiceType());

        Vehicles vehicles=new Vehicles();
        vehicles.setVehicleType(vehicle.getVehicleType());

        Double totalFee= (serviceFee(service1,vehicles)*appointmentDTO.getDiscount())/100;

        System.out.println(service1.getServiceType());
        System.out.println(vehicles.getVehicleType());
        System.out.println(serviceFee(service1,vehicles));
        // Create and save appointment
        Appointment appointment = new Appointment();
        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
        appointment.setVehicle(vehicle);
        appointment.setUser(user);
        appointment.setService(service);
        appointment.setNote(appointmentDTO.getNote());
        appointment.setServiceFee(serviceFee(service1,vehicles));
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

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found with ID: " + appointmentId));


        if (appointmentDTO.getUserId() == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        if (appointmentDTO.getServiceId() == null) {
            throw new IllegalArgumentException("Service ID cannot be null");
        }
        if (appointmentDTO.getVehicleId() == null) {
            throw new IllegalArgumentException("Vehicle ID cannot be null");
        }


        Vehicles vehicle = vehicleRepository.findById(appointmentDTO.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found with ID: " + appointmentDTO.getVehicleId()));
        appointment.setVehicle(vehicle);


        UserEntity user = userRepository.findById(appointmentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + appointmentDTO.getUserId()));
        appointment.setUser(user);


        ServiceEntity service = serviceRepository.findById(appointmentDTO.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found with ID: " + appointmentDTO.getServiceId()));
        appointment.setService(service);




        ServiceEntity service1=new ServiceEntity();
        service1.setServiceType(service.getServiceType());

        Vehicles vehicles=new Vehicles();
        vehicles.setVehicleType(vehicle.getVehicleType());

        Double totalFee= (serviceFee(service1,vehicles)*appointmentDTO.getDiscount())/100;

        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
        appointment.setNote(appointmentDTO.getNote());
        appointment.setServiceFee(serviceFee(service1,vehicles));
        appointment.setDiscount(appointmentDTO.getDiscount());
        appointment.setTotalFee(appointment.getServiceFee()-totalFee);

        return appointmentRepository.save(appointment);
    }

    private Double serviceFee(ServiceEntity serviceDTO, Vehicles vehicleDTO){
        if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.CAR && serviceDTO.getServiceType()== ServiceEntity.ServiceType.FULL_SERVICE){
            return 35000.0;
        } else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.CAR && serviceDTO.getServiceType()== ServiceEntity.ServiceType.BASIC_SERVICE) {
            return 25000.0;
        }else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.CAR && serviceDTO.getServiceType()== ServiceEntity.ServiceType.EXPRESS_SERVICE) {
            return 40000.0;
        } else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.VAN && serviceDTO.getServiceType()== ServiceEntity.ServiceType.FULL_SERVICE) {
            return 40000.0;
        }else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.VAN && serviceDTO.getServiceType()== ServiceEntity.ServiceType.BASIC_SERVICE) {
            return 30000.0;
        }else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.VAN && serviceDTO.getServiceType()== ServiceEntity.ServiceType.EXPRESS_SERVICE) {
            return 45000.0;
        }else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.BIKE && serviceDTO.getServiceType()== ServiceEntity.ServiceType.FULL_SERVICE) {
            return 5000.0;
        }else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.BIKE && serviceDTO.getServiceType()== ServiceEntity.ServiceType.BASIC_SERVICE) {
            return 3000.0;
        }else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.BIKE && serviceDTO.getServiceType()== ServiceEntity.ServiceType.EXPRESS_SERVICE) {
            return 7000.0;
        }else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.BUS && serviceDTO.getServiceType()== ServiceEntity.ServiceType.FULL_SERVICE) {
            return 50000.0;
        }else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.BUS && serviceDTO.getServiceType()== ServiceEntity.ServiceType.BASIC_SERVICE) {
            return 40000.0;
        }else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.BUS && serviceDTO.getServiceType()== ServiceEntity.ServiceType.EXPRESS_SERVICE) {
            return 55000.0;
        }else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.LORRY && serviceDTO.getServiceType()== ServiceEntity.ServiceType.FULL_SERVICE) {
            return 50000.0;
        }else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.LORRY && serviceDTO.getServiceType()== ServiceEntity.ServiceType.BASIC_SERVICE) {
            return 40000.0;
        }else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.LORRY && serviceDTO.getServiceType()== ServiceEntity.ServiceType.EXPRESS_SERVICE) {
            return 55000.0;
        }else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.SUV && serviceDTO.getServiceType()== ServiceEntity.ServiceType.FULL_SERVICE) {
            return 53000.0;
        }else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.SUV && serviceDTO.getServiceType()== ServiceEntity.ServiceType.BASIC_SERVICE) {
            return 42000.0;
        }else if (vehicleDTO.getVehicleType()== Vehicles.VehicleType.SUV && serviceDTO.getServiceType()== ServiceEntity.ServiceType.EXPRESS_SERVICE) {
            return 55000.0;
        }
        return 0.0;
    }

}
