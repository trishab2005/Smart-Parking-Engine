package com.example.service.impl;

import com.example.config.Converter;
import com.example.dto.ExitDTO;
import com.example.dto.ParkingRequestDTO;
import com.example.dto.ParkingResponseDTO;
import com.example.entity.ParkingRecord;
import com.example.entity.Slot;
import com.example.exception.BadRequestException;
import com.example.exception.ResourceNotFoundException;
import com.example.exception.SlotNotAvailableException;
import com.example.repository.ParkingRepository;
import com.example.repository.SlotRepository;
import com.example.service.ParkingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ParkingServiceImpl implements ParkingService {

    private ParkingRepository parkingRepository;
    private SlotRepository slotRepository;
    private Converter converter;

    // Park vehicle
    @Override
    public ParkingResponseDTO parkVehicle(ParkingRequestDTO dto) {
        Slot slot = slotRepository
                .findFirstByTypeAndOccupiedFalse(dto.vehicleType())
                .orElseThrow(() ->
                        new SlotNotAvailableException("No slot available"));

        ParkingRecord record = converter.toParkingEntity(dto);

        record.setEntryTime(LocalDateTime.now());
        record.setSlotId(slot.getId());

        slot.setOccupied(true);
        slotRepository.save(slot);

        ParkingRecord saved = parkingRepository.save(record);

        return converter.toParkingResponseDTO(saved);
    }

    // Exit Vehicle
    @Override
    public ParkingResponseDTO exitVehicle(ExitDTO dto) {
        ParkingRecord record= parkingRepository.findById(dto.recordId())
                .orElseThrow(
                        ()->new ResourceNotFoundException("record not found exception")
                );
        if (record.getExitTime()!=null){
            throw new BadRequestException("Vehcile already exited");
        }
        record.setExitTime(LocalDateTime.now());

        Long hours = Duration.between(
                record.getEntryTime(),
                record.getExitTime()
        ).toHours();

        if (hours == 0) hours = 1L;

        record.setFee(hours * 20.0);

        Slot slot = slotRepository.findById(record.getSlotId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Slot not found"));

        slot.setOccupied(false);
        slotRepository.save(slot);

        ParkingRecord updated = parkingRepository.save(record);

        return converter.toParkingResponseDTO(updated);
    }

    // get all records
    @Override
    public List<ParkingResponseDTO> getAllRecords() {
        return parkingRepository.findAll()
                .stream()
                .map(converter::toParkingResponseDTO)
                .toList();
    }

    // get by id
    @Override
    public ParkingResponseDTO getRecordById(Long id) {
        ParkingRecord record = parkingRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Record not found"));

        return converter.toParkingResponseDTO(record);
    }

    // get by active parkings
    @Override
    public List<ParkingResponseDTO> getActiveParkings() {
        return parkingRepository.findByExitTimeIsNull()
                .stream()
                .map(converter::toParkingResponseDTO)
                .toList();
    }

    // get by vehicle number
    @Override
    public List<ParkingResponseDTO> getByVehicleNumber(String vehicleNumber) {
        return parkingRepository.findByVehicleNumber(vehicleNumber)
                .stream()
                .map(converter::toParkingResponseDTO)
                .toList();
    }
}
