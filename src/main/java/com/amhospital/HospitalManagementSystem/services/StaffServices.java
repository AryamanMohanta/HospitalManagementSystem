package com.amhospital.HospitalManagementSystem.services;

import com.amhospital.HospitalManagementSystem.DTO.StaffDto;

public interface StaffServices  {
    StaffDto addStaff(StaffDto staffDto);

    Boolean removeStaff(Integer staffId);

    StaffDto getStaff(Integer staffId);

    StaffDto updateStaff(StaffDto staffDto);
}