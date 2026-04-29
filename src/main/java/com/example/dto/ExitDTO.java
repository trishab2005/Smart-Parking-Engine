package com.example.dto;

import jakarta.validation.constraints.NotNull;

public record ExitDTO(

        @NotNull(message = "Parking record id is required")
        Long recordId

) {}