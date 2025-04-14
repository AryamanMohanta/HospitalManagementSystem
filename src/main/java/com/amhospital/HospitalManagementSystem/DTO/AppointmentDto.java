package com.amhospital.HospitalManagementSystem.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDto {
    private Integer appointmentId;

    private String staffName;
    private String patientName;
    private Date appointmentDate;
    private String status;
}
