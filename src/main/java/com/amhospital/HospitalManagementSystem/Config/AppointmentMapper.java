package com.amhospital.HospitalManagementSystem.Config;

import com.amhospital.HospitalManagementSystem.DTO.AppointmentDto;
    import com.amhospital.HospitalManagementSystem.model.Appointment;
import com.amhospital.HospitalManagementSystem.model.Doctor;
import com.amhospital.HospitalManagementSystem.model.Patient;
import com.amhospital.HospitalManagementSystem.repositories.DoctorRepo;
import com.amhospital.HospitalManagementSystem.repositories.PatientRepo;
import org.mapstruct.Mapper;
    import org.mapstruct.Mapping;
    import org.mapstruct.factory.Mappers;

    @Mapper(componentModel = "spring")
    public interface AppointmentMapper {
        AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

        @Mapping(target = "doctorId", ignore = true) // Custom mapping for doctorId
        @Mapping(target = "patientId", ignore = true) // Custom mapping for patientId
        Appointment toEntity(AppointmentDto appointmentDto);

        @Mapping(target = "doctorName", ignore = true) // Custom mapping for doctorName
        @Mapping(target = "patientName", ignore = true) // Custom mapping for patientName
        AppointmentDto toDto(Appointment appointment);

        default Appointment toEntityWithMapping(AppointmentDto appointmentDto, DoctorRepo doctorRepo, PatientRepo patientRepo) {
            Appointment appointment = toEntity(appointmentDto);
            Doctor doctor = doctorRepo.findByName(appointmentDto.getDoctorName())
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));
            Patient patient = patientRepo.findByName(appointmentDto.getPatientName())
                    .orElseThrow(() -> new RuntimeException("Patient not found"));
            appointment.setDoctorId(doctor.getDoctorId());
            appointment.setPatientId(patient.getPatientId());
            return appointment;
        }

        default AppointmentDto toDtoWithMapping(Appointment appointment, DoctorRepo doctorRepo, PatientRepo patientRepo) {
            AppointmentDto appointmentDto = toDto(appointment);
            Doctor doctor = doctorRepo.findById(appointment.getDoctorId())
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));
            Patient patient = patientRepo.findById(appointment.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Patient not found"));
            appointmentDto.setDoctorName(doctor.getName());
            appointmentDto.setPatientName(patient.getName());
            return appointmentDto;
        }
    }