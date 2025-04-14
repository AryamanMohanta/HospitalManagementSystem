package com.amhospital.HospitalManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer medicineId;
    String name;
    Date manufactureDate;
    Date expiryDate;
    Integer medicineQuantity;
    Integer medicinePrice;
}
