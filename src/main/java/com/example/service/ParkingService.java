package com.example.service;

import com.example.dto.ExitDTO;
import com.example.dto.ParkingRequestDTO;
import com.example.dto.ParkingResponseDTO;

import java.util.List;

public interface ParkingService {

    // Park a vehicle
    ParkingResponseDTO parkVehicle(ParkingRequestDTO dto);

    // Exit vehicle + calculate fee
    ParkingResponseDTO exitVehicle(ExitDTO dto);

    // Get all parking records
    List<ParkingResponseDTO> getAllRecords();

    // Get record by ID
    ParkingResponseDTO getRecordById(Long id);

    // Get active parked vehicles
    List<ParkingResponseDTO> getActiveParkings();

    // Get parking history by vehicle number
    List<ParkingResponseDTO> getByVehicleNumber(String vehicleNumber);

}
