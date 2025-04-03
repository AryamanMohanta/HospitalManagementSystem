package com.amhospital.HospitalManagementSystem.DTO;

import lombok.Data;

import java.util.Date;
@Data
public class PatientDto {
    Integer patientId;
    String name;
    String address;
    Integer age;
    Long phoneNo;
    Date dob;
    String gender;
    String email;
    String medicalHistory;
}
