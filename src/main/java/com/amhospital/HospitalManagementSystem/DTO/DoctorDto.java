package com.amhospital.HospitalManagementSystem.DTO;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Data
public class DoctorDto {
    Integer doctor_id;
    String name;
    String specialisation;
    Integer experience;
    Long phNumber;
    Date dob;
    String gender;

    Map<String , Boolean> availability = new HashMap<>();
}
