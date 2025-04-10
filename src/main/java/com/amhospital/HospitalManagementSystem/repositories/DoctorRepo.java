package com.amhospital.HospitalManagementSystem.repositories;

import com.amhospital.HospitalManagementSystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
    Doctor findByName(String name);
}
