package com.amhospital.HospitalManagementSystem.Controller;

import com.amhospital.HospitalManagementSystem.DTO.AppointmentDto;
import com.amhospital.HospitalManagementSystem.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/create")
    public ResponseEntity<AppointmentDto> addAppointment(@RequestBody AppointmentDto appointmentDto) {
        return ResponseEntity.status(201).body(appointmentService.createAppointment(appointmentDto));
    }

    @DeleteMapping("/remove/{appointmentId}")
    public ResponseEntity<Boolean> removeAppointment(@PathVariable Integer appointmentId) {
        return ResponseEntity.ok(appointmentService.deleteAppointment(appointmentId));
    }

    @GetMapping("/get/{appointmentId}")
    public ResponseEntity<AppointmentDto> getAppointment(@PathVariable Integer appointmentId) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(appointmentId));
    }

    @PutMapping("/update")
    public ResponseEntity<AppointmentDto> updateAppointment(@RequestBody AppointmentDto appointmentDto) {
        return ResponseEntity.status(201).body(appointmentService.updateAppointment(appointmentDto));
    }
}