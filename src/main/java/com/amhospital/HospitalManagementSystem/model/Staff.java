package com.amhospital.HospitalManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer staffId;
    String name;
    String role;
    Integer experience;
    Long contactNumber;
    String gender;
}
