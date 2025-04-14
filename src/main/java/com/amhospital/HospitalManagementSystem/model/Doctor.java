package com.amhospital.HospitalManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer doctorId;
    String name;
    String specialisation;
    Integer experience;
    Long phNumber;
    Date dob;
    String gender;
    @ElementCollection
            @CollectionTable(name = "doctor_availability" , joinColumns =
            @JoinColumn(name="doctorId"))
            @MapKeyColumn(name="slot")
            @Column(name = "is_available")
    Map<String , Boolean> availability = new HashMap<>();
}
