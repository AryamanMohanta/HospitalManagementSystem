package com.amhospital.HospitalManagementSystem.Controller;



import com.amhospital.HospitalManagementSystem.DTO.PatientDto;
import com.amhospital.HospitalManagementSystem.services.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/add")
    public ResponseEntity<PatientDto> addPatient(@RequestBody PatientDto patientDto) {
        // Logic to add a patient
        return ResponseEntity.status(201).body(patientService.addPatient(patientDto));
    }

    @DeleteMapping("/remove/{patientId}")
    public ResponseEntity<Boolean> removePatient(@PathVariable Integer patientId) {
        // Logic to remove a patient
        return ResponseEntity.ok(patientService.removePatient(patientId));
    }

    @GetMapping("/get/{patientId}")
    public ResponseEntity<PatientDto> getPatient(@PathVariable Integer patientId) {
        // Logic to get a patient
        return ResponseEntity.ok(patientService.getPatient(patientId));
    }

}