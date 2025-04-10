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
    Integer doctor_id;
    String name;
    String specialisation;
    Integer experience;
    Long phNumber;
    Date dob;
    String gender;
    @ElementCollection
            @CollectionTable(name = "doctor_availability" , joinColumns =
            @JoinColumn(name="doctor_id"))
            @MapKeyColumn(name="slot")
            @Column(name = "is_available")
    Map<String , Boolean> availability = new HashMap<>();
}
