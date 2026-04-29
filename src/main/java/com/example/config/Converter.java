package com.example.config;

import com.example.dto.*;
import com.example.entity.ParkingRecord;
import com.example.entity.Slot;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    //ParkingRequestDTO -> ParkingRecord
    public ParkingRecord toParkingEntity(ParkingRequestDTO dto) {

        return ParkingRecord.builder()
                .vehicleNumber(dto.vehicleNumber())
                .vehicleType(dto.vehicleType())
                .build();
    }

    //ParkingRecord -> ParkingResponseDTO
    public ParkingResponseDTO toParkingResponseDTO(ParkingRecord entity) {

        return new ParkingResponseDTO(
                entity.getId(),
                entity.getVehicleNumber(),
                entity.getVehicleType(),
                entity.getEntryTime(),
                entity.getExitTime(),
                entity.getFee(),
                entity.getSlotId()
        );
    }

    //SlotDTO -> Slot Entity
    public Slot toSlotEntity(SlotDTO dto) {

        return Slot.builder()
                .id(dto.id())
                .type(dto.type())
                .occupied(dto.occupied())
                .build();
    }

    //Slot Entity -> SlotDTO
    public SlotDTO toSlotDTO(Slot entity) {

        return new SlotDTO(
                entity.getId(),
                entity.getType(),
                entity.getOccupied()
        );
    }
}