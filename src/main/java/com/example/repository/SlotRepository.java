package com.example.repository;

import com.example.entity.Slot;
import com.example.entity.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SlotRepository extends JpaRepository<Slot,Long> {

    Optional<Slot> findFirstByTypeAndOccupiedFalse(VehicleType type);

    List<Slot> findByTypeAndOccupiedFalse(VehicleType type);

    List<Slot> findByOccupiedTrue();

}
