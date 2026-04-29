package com.example.repository;

import com.example.entity.ParkingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingRepository extends JpaRepository<ParkingRecord,Long> {

    List<ParkingRecord> findByExitTimeIsNull();

    List<ParkingRecord> findByVehicleNumber(String vehicleNumber);

    List<ParkingRecord> findByVehicleNumberAndExitTimeIsNull(String vehicleNumber);

}
