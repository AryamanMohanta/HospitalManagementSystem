package com.amhospital.HospitalManagementSystem.services.serviceImpl;

import com.amhospital.HospitalManagementSystem.Config.DoctorMapper;
import com.amhospital.HospitalManagementSystem.DTO.DoctorDto;
import com.amhospital.HospitalManagementSystem.model.Doctor;
import com.amhospital.HospitalManagementSystem.repositories.DoctorRepo;
import com.amhospital.HospitalManagementSystem.services.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorServices {

    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public DoctorDto addDoctor(DoctorDto doctorDto) {
        Doctor doctor = DoctorMapper.INSTANCE.toEntity(doctorDto);
        return DoctorMapper.INSTANCE.toDto(doctorRepo.save(doctor));
    }

    @Override
    public Boolean removeDoctor(Integer doctorId) {
        if(doctorRepo.existsById(doctorId)){
            doctorRepo.deleteById(doctorId);
            return true;
        }
        return false;
    }

    @Override
    public DoctorDto getDoctor(Integer doctorId) {
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow(()->new RuntimeException("Doctor not found"));
        return DoctorMapper.INSTANCE.toDto(doctor);
    }

    @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto) {
        if (doctorRepo.existsById(doctorDto.getDoctorId())){
            Doctor doctor = DoctorMapper.INSTANCE.toEntity(doctorDto);
            return DoctorMapper.INSTANCE.toDto(doctorRepo.save(doctor));
        }
        throw new RuntimeException("Doctor not found");
    }
}
