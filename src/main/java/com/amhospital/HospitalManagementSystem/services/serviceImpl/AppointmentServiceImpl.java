package com.amhospital.HospitalManagementSystem.services.serviceImpl;

import com.amhospital.HospitalManagementSystem.Config.AppointmentMapper;
import com.amhospital.HospitalManagementSystem.DTO.AppointmentDto;
import com.amhospital.HospitalManagementSystem.model.Appointment;
import com.amhospital.HospitalManagementSystem.repositories.AppointmentRepo;
import com.amhospital.HospitalManagementSystem.repositories.PatientRepo;
import com.amhospital.HospitalManagementSystem.repositories.StaffRepo;
import com.amhospital.HospitalManagementSystem.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private StaffRepo staffRepo;

    @Autowired
    private PatientRepo patientRepo;
    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = AppointmentMapper.INSTANCE.toEntityWithMapping(appointmentDto, staffRepo, patientRepo);
        return AppointmentMapper.INSTANCE.toDtoWithMapping(appointmentRepo.save(appointment), staffRepo, patientRepo);
    }

    @Override
    public AppointmentDto getAppointmentById(Integer appointmentId) {
        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        return AppointmentMapper.INSTANCE.toDto(appointment);
    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto appointmentDto) {
        if (appointmentRepo.existsById(appointmentDto.getAppointmentId())) {
            Appointment appointment = AppointmentMapper.INSTANCE.toEntityWithMapping(appointmentDto, staffRepo, patientRepo);
            return AppointmentMapper.INSTANCE.toDtoWithMapping(appointmentRepo.save(appointment), staffRepo, patientRepo);
        }
        throw new RuntimeException("Appointment not found");
    }

    @Override
    public Boolean deleteAppointment(Integer appointmentId) {
        if (appointmentRepo.existsById(appointmentId)) {
            appointmentRepo.deleteById(appointmentId);
            return true;
        } else {
            throw new RuntimeException("Appointment not found");
        }
    }

    @Override
    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> appointments = appointmentRepo.findAll();
        return null;
    }
}
