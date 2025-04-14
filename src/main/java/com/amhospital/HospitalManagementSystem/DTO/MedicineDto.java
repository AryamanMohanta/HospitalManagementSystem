package com.amhospital.HospitalManagementSystem.DTO;

import lombok.Data;

import java.util.Date;
@Data
public class MedicineDto {
    Integer medicineId;
    String name;
    Date manufactureDate;
    Date expiryDate;
    Integer medicineQuantity;
    Integer medicinePrice;
}
