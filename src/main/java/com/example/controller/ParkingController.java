package com.example.controller;

import com.example.dto.ExitDTO;
import com.example.dto.ParkingRequestDTO;
import com.example.dto.ParkingResponseDTO;
import com.example.service.ParkingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@CrossOrigin(origins = "http://localhost:5173")
@AllArgsConstructor
public class ParkingController {

    private ParkingService parkingService;

    // Park vehicle
    @PostMapping("/park")
    public ParkingResponseDTO parkVehicle(@Valid @RequestBody ParkingRequestDTO dto) {
        return parkingService.parkVehicle(dto);
    }

    // Exit vehicle
    @PostMapping("/exit")
    public ParkingResponseDTO exitVehicle(@Valid @RequestBody ExitDTO dto) {
        return parkingService.exitVehicle(dto);
    }

    // Get all records
    @GetMapping
    public List<ParkingResponseDTO> getAllRecords() {
        return parkingService.getAllRecords();
    }

    // Get by ID
    @GetMapping("/{id}")
    public ParkingResponseDTO getById(@PathVariable Long id) {
        return parkingService.getRecordById(id);
    }

    // Get active parked vehicles
    @GetMapping("/active")
    public List<ParkingResponseDTO> getActiveParkings() {
        return parkingService.getActiveParkings();
    }

    // Get by vehicle number
    @GetMapping("/vehicle/{vehicleNumber}")
    public List<ParkingResponseDTO> getByVehicleNumber(@PathVariable String vehicleNumber) {
        return parkingService.getByVehicleNumber(vehicleNumber);
    }

}
