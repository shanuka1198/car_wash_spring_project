package com.carwash.S.I_car_wash.dto;

import com.carwash.S.I_car_wash.Entity.ServiceEntity;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ServiceResponseDTO {
    @JsonProperty("serviceId")
    private Long serviceId;
    @JsonProperty("serviceType")
    private String serviceType;

    public ServiceResponseDTO(ServiceEntity service) {
        this.serviceId = service.getServiceId();
        this.serviceType = service.getServiceType().name();

    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

}
