package com.example.repository;

import com.example.entity.ParkingRecord;
import com.example.entity.VehicleType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback
class ParkingRepositoryTest {

    @Autowired
    private ParkingRepository parkingRepository;

    @Test
    void shouldSaveAndFetchActiveParking() {

        ParkingRecord record = ParkingRecord.builder()
                .vehicleNumber("WBTEST")
                .vehicleType(VehicleType.CAR)
                .entryTime(LocalDateTime.now())
                .slotId(1L)
                .build();

        parkingRepository.save(record);

        List<ParkingRecord> result =
                parkingRepository.findByExitTimeIsNull();

        assertThat(result).isNotEmpty();
    }
}