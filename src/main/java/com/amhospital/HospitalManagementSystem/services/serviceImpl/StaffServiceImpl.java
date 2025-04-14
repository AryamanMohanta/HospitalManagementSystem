package com.amhospital.HospitalManagementSystem.services.serviceImpl;

import com.amhospital.HospitalManagementSystem.Config.StaffMapper;
import com.amhospital.HospitalManagementSystem.DTO.StaffDto;

import com.amhospital.HospitalManagementSystem.model.Staff;
import com.amhospital.HospitalManagementSystem.repositories.StaffRepo;
import com.amhospital.HospitalManagementSystem.services.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffServices {

    @Autowired
    private StaffRepo staffRepo;

    @Override
    public StaffDto addStaff(StaffDto staffDto) {
        Staff staff = StaffMapper.INSTANCE.toEntity(staffDto);
        return StaffMapper.INSTANCE.toDto(staffRepo.save(staff));
    }

    @Override
    public Boolean removeStaff(Integer doctorId) {
        if (staffRepo.existsById(doctorId)) {
            staffRepo.deleteById(doctorId);
            return true;
        }
        return false;
    }

    @Override
    public StaffDto getStaff(Integer staffId) {
        Staff staff = staffRepo.findById(staffId).orElseThrow(() -> new RuntimeException("Doctor not found"));
        return StaffMapper.INSTANCE.toDto(staff);
    }

    @Override
    public StaffDto updateStaff(StaffDto staffDto) {
        if (staffRepo.existsById(staffDto.getStaffId())) {
            Staff staff = StaffMapper.INSTANCE.toEntity(staffDto);
            return StaffMapper.INSTANCE.toDto(staffRepo.save(staff));
        }
        throw new RuntimeException("Doctor not found");
    }
}