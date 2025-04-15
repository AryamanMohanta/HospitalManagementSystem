package com.amhospital.HospitalManagementSystem.Controller;

import com.amhospital.HospitalManagementSystem.DTO.MedicineDto;
import com.amhospital.HospitalManagementSystem.services.MedicineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/add")
    public ResponseEntity<MedicineDto> addMedicine(@RequestBody MedicineDto medicineDto) {
        // Logic to add a medicine
        return ResponseEntity.status(201).body(medicineService.addMedicine(medicineDto));
    }

    @DeleteMapping("/remove/{medicineId}")
    public ResponseEntity<Boolean> removeMedicine(@PathVariable Integer medicineId) {
        // Logic to remove a medicine
        return ResponseEntity.ok(medicineService.removeMedicine(medicineId));
    }

    @GetMapping("/get/{medicineId}")
    public ResponseEntity<MedicineDto> getMedicine(@PathVariable Integer medicineId) {
        // Logic to get a medicine
        return ResponseEntity.ok(medicineService.getMedicine(medicineId));
    }

    @PutMapping("/update")
    public ResponseEntity<MedicineDto> updateMedicine(@RequestBody MedicineDto medicineDto) {
        return ResponseEntity.status(200).body(medicineService.updateMedicine(medicineDto));
    }

}