package com.example.repository;

import com.example.entity.Slot;
import com.example.entity.VehicleType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback
class SlotRepositoryTest {

    @Autowired
    private SlotRepository slotRepository;

    // find available slot
    @Test
    void shouldFindFirstAvailableSlot() {

        Slot slot = Slot.builder()
                .type(VehicleType.CAR)
                .occupied(false)
                .build();

        slotRepository.save(slot);

        Optional<Slot> result =
                slotRepository.findFirstByTypeAndOccupiedFalse(VehicleType.CAR);

        assertThat(result).isPresent();
        assertThat(result.get().getOccupied()).isFalse();
    }

    // find available slots list
    @Test
    void shouldReturnAvailableSlotsByType() {

        slotRepository.deleteAll(); // 🔥 IMPORTANT

        slotRepository.save(Slot.builder()
                .type(VehicleType.BIKE)
                .occupied(false)
                .build());

        slotRepository.save(Slot.builder()
                .type(VehicleType.BIKE)
                .occupied(true)
                .build());

        List<Slot> result =
                slotRepository.findByTypeAndOccupiedFalse(VehicleType.BIKE);

        assertThat(result).hasSize(1);
    }

    // find occupied slots
    @Test
    void shouldReturnOccupiedSlots() {

        slotRepository.save(Slot.builder()
                .type(VehicleType.CAR)
                .occupied(true)
                .build());

        List<Slot> result =
                slotRepository.findByOccupiedTrue();

        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getOccupied()).isTrue();
    }
}