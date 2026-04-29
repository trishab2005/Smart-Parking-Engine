package com.example.service.impl;

import com.example.config.Converter;
import com.example.dto.SlotDTO;
import com.example.entity.Slot;
import com.example.entity.VehicleType;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.SlotRepository;
import com.example.service.SlotService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SlotServiceImpl implements SlotService {

    private final SlotRepository slotRepository;
    private final Converter converter;

    // Create slot
    @Override
    public SlotDTO createSlot(SlotDTO dto) {
        Slot slot = converter.toSlotEntity(dto);
        Slot saved = slotRepository.save(slot);
        return converter.toSlotDTO(saved);
    }

    // Get all slots
    @Override
    public List<SlotDTO> getAllSlots() {
        return slotRepository.findAll()
                .stream()
                .map(converter::toSlotDTO)
                .toList();
    }

    // Get slot by ID
    @Override
    public SlotDTO getSlotById(Long id) {
        Slot slot = slotRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Slot not found with id: " + id));

        return converter.toSlotDTO(slot);
    }

    // Delete slot
    @Override
    public void deleteSlot(Long id) {
        if (!slotRepository.existsById(id)) {
            throw new ResourceNotFoundException("Slot not found with id: " + id);
        }
        slotRepository.deleteById(id);
    }

    // Available slots by type
    @Override
    public List<SlotDTO> getAvailableSlots(VehicleType type) {
        return slotRepository.findByTypeAndOccupiedFalse(type)
                .stream()
                .map(converter::toSlotDTO)
                .toList();
    }

    // Occupied slots
    @Override
    public List<SlotDTO> getOccupiedSlots() {
        return slotRepository.findByOccupiedTrue()
                .stream()
                .map(converter::toSlotDTO)
                .toList();
    }
}