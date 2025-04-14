package com.amhospital.HospitalManagementSystem.services;

import com.amhospital.HospitalManagementSystem.DTO.MedicineDto;

public interface MedicineService {
   MedicineDto addMedicine(MedicineDto medicineDto);

   Boolean removeMedicine(Integer medicineId);

   MedicineDto getMedicine(Integer medicineId);

   MedicineDto updateMedicine(MedicineDto medicineDto);
}

