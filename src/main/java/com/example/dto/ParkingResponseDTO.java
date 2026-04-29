package com.example.dto;

import com.example.entity.VehicleType;

import java.time.LocalDateTime;

public record ParkingResponseDTO(

        Long id,
        String vehicleNumber,
        VehicleType vehicleType,
        LocalDateTime entryTime,
        LocalDateTime exitTime,
        Double fee,
        Long slotId

) {}