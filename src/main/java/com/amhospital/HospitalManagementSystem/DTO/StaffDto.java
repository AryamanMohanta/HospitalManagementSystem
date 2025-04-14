package com.amhospital.HospitalManagementSystem.DTO;

import lombok.Data;

@Data
public class StaffDto {
    Integer staffId;
    String name;
    String role;
    Integer experience;
    Long contactNumber;
    String gender;
}
