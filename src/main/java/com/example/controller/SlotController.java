package com.example.controller;

import com.example.dto.SlotDTO;
import com.example.entity.VehicleType;
import com.example.service.SlotService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slots")
@CrossOrigin(origins = "http://localhost:5173")
@AllArgsConstructor
public class SlotController {

    private SlotService slotService;

    // Create slot
    @PostMapping
    public SlotDTO createSlot(@Valid @RequestBody SlotDTO dto) {
        return slotService.createSlot(dto);
    }

    // Get all slots
    @GetMapping
    public List<SlotDTO> getAllSlots() {
        return slotService.getAllSlots();
    }

    // Get slot by ID
    @GetMapping("/{id}")
    public SlotDTO getSlotById(@PathVariable Long id) {
        return slotService.getSlotById(id);
    }

    // Delete slot
    @DeleteMapping("/{id}")
    public String deleteSlot(@PathVariable Long id) {
        slotService.deleteSlot(id);
        return "Slot deleted successfully";
    }

    // Get available slots by type
    @GetMapping("/available")
    public List<SlotDTO> getAvailableSlots(@RequestParam VehicleType type) {
        return slotService.getAvailableSlots(type);
    }

    // Get occupied slots
    @GetMapping("/occupied")
    public List<SlotDTO> getOccupiedSlots() {
        return slotService.getOccupiedSlots();
    }
}