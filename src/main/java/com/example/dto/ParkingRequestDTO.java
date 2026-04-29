package com.example.dto;

import com.example.entity.VehicleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ParkingRequestDTO(

        @NotBlank(message = "Vehicle number is required")
        String vehicleNumber,

        @NotNull(message = "Vehicle type is required")
        VehicleType vehicleType

) {}