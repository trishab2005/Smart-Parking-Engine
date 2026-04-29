package com.example.service;

import com.example.dto.SlotDTO;
import com.example.entity.VehicleType;

import java.util.List;

public interface SlotService {

    // Add slot
    SlotDTO createSlot(SlotDTO dto);

    // Get all slots
    List<SlotDTO> getAllSlots();

    // Get slot by ID
    SlotDTO getSlotById(Long id);

    // Delete slot
    void deleteSlot(Long id);

    // Get available slots by type
    List<SlotDTO> getAvailableSlots(VehicleType type);

    // Get all occupied slots
    List<SlotDTO> getOccupiedSlots();
}
