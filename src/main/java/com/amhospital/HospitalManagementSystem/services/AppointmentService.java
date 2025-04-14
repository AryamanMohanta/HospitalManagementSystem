package com.amhospital.HospitalManagementSystem.services;

import com.amhospital.HospitalManagementSystem.DTO.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    AppointmentDto createAppointment(AppointmentDto appointmentDto);

    AppointmentDto getAppointmentById(Integer appointmentId);

    AppointmentDto updateAppointment(Integer appointmentId, AppointmentDto appointmentDto);

    void deleteAppointment(Integer appointmentId);

    List<AppointmentDto> getAllAppointments();
}
