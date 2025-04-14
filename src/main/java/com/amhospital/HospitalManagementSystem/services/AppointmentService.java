package com.amhospital.HospitalManagementSystem.services;

import com.amhospital.HospitalManagementSystem.DTO.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    AppointmentDto createAppointment(AppointmentDto appointmentDto);

    AppointmentDto getAppointmentById(Integer appointmentId);

    AppointmentDto updateAppointment(AppointmentDto appointmentDto);

    Boolean deleteAppointment(Integer appointmentId);

    List<AppointmentDto> getAllAppointments();
}
