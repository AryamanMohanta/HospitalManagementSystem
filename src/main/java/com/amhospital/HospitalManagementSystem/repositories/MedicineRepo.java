package com.amhospital.HospitalManagementSystem.repositories;

import com.amhospital.HospitalManagementSystem.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Integer> {
    Medicine findByName(String name);
}
