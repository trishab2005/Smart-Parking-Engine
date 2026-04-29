package com.example.config;

import com.example.entity.ParkingRecord;
import com.example.entity.Slot;
import com.example.entity.VehicleType;
import com.example.repository.ParkingRepository;
import com.example.repository.SlotRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Configuration
@RequiredArgsConstructor
public class DataLoader {

    @Bean
    CommandLineRunner loadData(SlotRepository slotRepo, ParkingRepository parkingRepo) {
        return args -> {

            // Prevent duplicate data on restart
            if (slotRepo.count() > 0) {
                return;
            }

            Faker faker = new Faker();
            Random random = new Random();

            // CREATE SLOTS

            Random rand = new Random();

            for (int i = 1; i <= 50; i++) {
                Slot slot = new Slot();

                slot.setType(i % 2 == 0 ? VehicleType.CAR : VehicleType.BIKE);

                // 🔥 50% chance occupied
                boolean isOccupied = rand.nextBoolean();
                slot.setOccupied(isOccupied);

                slotRepo.save(slot);
            }


            // FETCH ALL SLOTS

            List<Slot> allSlots = slotRepo.findAll();

            // CREATE PARKING RECORDS

            List<Slot> allslots = slotRepo.findAll();

            for (Slot slot : allslots) {

                if (slot.getOccupied()) {

                    ParkingRecord record = new ParkingRecord();

                    record.setVehicleNumber(faker.bothify("??##??####"));
                    record.setVehicleType(slot.getType());
                    record.setEntryTime(LocalDateTime.now().minusHours(random.nextInt(5) + 1));
                    record.setExitTime(null);
                    record.setFee(0.0);

                    record.setSlotId(slot.getId());

                    parkingRepo.save(record);
                }
            }
        };
    }
}