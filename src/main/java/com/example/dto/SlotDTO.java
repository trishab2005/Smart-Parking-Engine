package com.example.dto;

import com.example.entity.VehicleType;

public record SlotDTO(

        Long id,
        VehicleType type,
        Boolean occupied

) {}