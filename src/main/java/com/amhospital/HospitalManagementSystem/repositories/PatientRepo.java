package com.amhospital.HospitalManagementSystem.repositories;

import com.amhospital.HospitalManagementSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface PatientRepo extends JpaRepository<Patient , Integer > {
    Patient findByName(String name);
    Patient findByPatientId(Integer Id);
}
