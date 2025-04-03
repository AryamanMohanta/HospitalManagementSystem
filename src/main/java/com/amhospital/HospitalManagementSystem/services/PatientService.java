package com.amhospital.HospitalManagementSystem.services;

import com.amhospital.HospitalManagementSystem.DTO.PatientDto;

public interface PatientService {
    PatientDto addPatient(PatientDto patientDto);

    Boolean removePatient(Integer patientId);

    PatientDto getPatient(Integer patientId);

    PatientDto updatePatient(PatientDto patientDto);
}
