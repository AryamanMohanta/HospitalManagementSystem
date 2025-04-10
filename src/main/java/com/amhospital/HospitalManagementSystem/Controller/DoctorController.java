package com.amhospital.HospitalManagementSystem.Controller;

import com.amhospital.HospitalManagementSystem.DTO.DoctorDto;
import com.amhospital.HospitalManagementSystem.services.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorServices doctorServices;

    @PostMapping("/add")
    public ResponseEntity<DoctorDto> addDoctor(@RequestBody DoctorDto doctorDto) {
        return ResponseEntity.status(201).body(doctorServices.addDoctor(doctorDto));
    }

    @DeleteMapping("/remove/{doctorId}")
    public ResponseEntity<Boolean> removePatient(@PathVariable Integer doctorId) {
        return ResponseEntity.ok(doctorServices.removeDoctor(doctorId));
    }

    @GetMapping("/get/{doctorId}")
    public ResponseEntity<DoctorDto> getPatient(@PathVariable Integer doctorId) {
        return ResponseEntity.ok(doctorServices.getDoctor(doctorId));
    }

    @PutMapping("/update")
    public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto doctorDto) {
        return ResponseEntity.status(201).body(doctorServices.updateDoctor(doctorDto));
    }



}