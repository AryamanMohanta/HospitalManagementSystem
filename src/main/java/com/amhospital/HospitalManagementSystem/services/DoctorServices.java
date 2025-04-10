package com.amhospital.HospitalManagementSystem.services;

import com.amhospital.HospitalManagementSystem.DTO.DoctorDto;
import com.amhospital.HospitalManagementSystem.DTO.PatientDto;

public interface DoctorServices  {
    DoctorDto addDoctor(DoctorDto doctorDto);

    Boolean removeDoctor(Integer doctorId);

    DoctorDto getDoctor(Integer doctorId);

    DoctorDto updateDoctor(DoctorDto doctorDto);
}

