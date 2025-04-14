package com.amhospital.HospitalManagementSystem.DTO;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Data
public class DoctorDto {
    Integer doctorId;
    String name;
    String specialisation;
    Integer experience;
    Long phNumber;
    Date dob;
    String gender;

    Map<String , Boolean> availability = new HashMap<>();
}
