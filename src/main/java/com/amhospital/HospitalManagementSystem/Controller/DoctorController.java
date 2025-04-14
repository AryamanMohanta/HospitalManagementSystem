package com.amhospital.HospitalManagementSystem.Controller;

import com.amhospital.HospitalManagementSystem.DTO.StaffDto;
import com.amhospital.HospitalManagementSystem.services.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
public class DoctorController {
    @Autowired
    private StaffServices staffServices;

    @PostMapping("/add")
    public ResponseEntity<StaffDto> addDoctor(@RequestBody StaffDto staffDto) {
        return ResponseEntity.status(201).body(staffServices.addStaff(staffDto));
    }

    @DeleteMapping("/remove/{staffId}")
    public ResponseEntity<Boolean> removePatient(@PathVariable Integer staffId) {
        return ResponseEntity.ok(staffServices.removeStaff(staffId));
    }

    @GetMapping("/get/{staffId}")
    public ResponseEntity<StaffDto> getPatient(@PathVariable Integer staffId) {
        return ResponseEntity.ok(staffServices.getStaff(staffId));
    }

    @PutMapping("/update")
    public ResponseEntity<StaffDto> updateDoctor(@RequestBody StaffDto staffDto) {
        return ResponseEntity.status(201).body(staffServices.updateStaff(staffDto));
    }



}