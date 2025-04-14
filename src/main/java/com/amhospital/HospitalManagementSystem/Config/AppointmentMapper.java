package com.amhospital.HospitalManagementSystem.Config;

import com.amhospital.HospitalManagementSystem.DTO.AppointmentDto;
    import com.amhospital.HospitalManagementSystem.model.Appointment;
import com.amhospital.HospitalManagementSystem.model.Patient;
import com.amhospital.HospitalManagementSystem.model.Staff;
import com.amhospital.HospitalManagementSystem.repositories.PatientRepo;
import com.amhospital.HospitalManagementSystem.repositories.StaffRepo;
import org.mapstruct.Mapper;
    import org.mapstruct.Mapping;
    import org.mapstruct.factory.Mappers;

    @Mapper(componentModel = "spring")
    public interface AppointmentMapper {
        AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

        @Mapping(target = "staffId", ignore = true)
        @Mapping(target = "patientId", ignore = true)
        Appointment toEntity(AppointmentDto appointmentDto);

        @Mapping(target = "staffName", ignore = true)
        @Mapping(target = "patientName", ignore = true)
        AppointmentDto toDto(Appointment appointment);

        default Appointment toEntityWithMapping(AppointmentDto appointmentDto, StaffRepo staffRepo, PatientRepo patientRepo) {
            Appointment appointment = toEntity(appointmentDto);
            Staff staff = staffRepo.findByName(appointmentDto.getStaffName())
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));
            Patient patient = patientRepo.findByName(appointmentDto.getPatientName())
                    .orElseThrow(() -> new RuntimeException("Patient not found"));
            appointment.setStaffId(staff.getStaffId());
            appointment.setPatientId(patient.getPatientId());
            return appointment;
        }

        default AppointmentDto toDtoWithMapping(Appointment appointment, StaffRepo staffRepo, PatientRepo patientRepo) {
            AppointmentDto appointmentDto = toDto(appointment);
            Staff staff = staffRepo.findById(appointment.getStaffId())
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));
            Patient patient = patientRepo.findById(appointment.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Patient not found"));
            appointmentDto.setStaffName(staff.getName());
            appointmentDto.setPatientName(patient.getName());
            return appointmentDto;
        }
    }