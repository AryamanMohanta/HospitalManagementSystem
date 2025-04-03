package com.amhospital.HospitalManagementSystem.services;

import com.amhospital.HospitalManagementSystem.Config.PatientMapper;
import com.amhospital.HospitalManagementSystem.DTO.PatientDto;
import com.amhospital.HospitalManagementSystem.model.Patient;
import com.amhospital.HospitalManagementSystem.repositories.PatientRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    private static final Logger log = LoggerFactory.getLogger(PatientService.class);
    @Autowired
    private PatientRepo patientRepo;


    @Override
    public PatientDto addPatient(PatientDto patientDto) {
        Patient patient = patientRepo.save(PatientMapper.INSTANCE.toEntity(patientDto));
        log.info("Patient added successfully with ID: {}", patient.getPatientId());
        return PatientMapper.INSTANCE.toDto(patient);
    }

    @Override
    public Boolean removePatient(Integer patientId) {
        if (patientRepo.existsById(patientId)) {
            patientRepo.deleteById(patientId);
            return true;
        }
        throw new RuntimeException("Patient not found");
    }

    @Override
    public PatientDto getPatient(Integer patientId) {
        return PatientMapper.INSTANCE.toDto(patientRepo.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found")));
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto) {
        if (patientRepo.existsById(patientDto.getPatientId())) {
            return PatientMapper.INSTANCE.toDto(patientRepo.save(PatientMapper.INSTANCE.toEntity(patientDto)));
        }
        throw new RuntimeException("Patient not found");
    }

}
