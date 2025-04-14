package com.amhospital.HospitalManagementSystem.repositories;

import com.amhospital.HospitalManagementSystem.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Integer> {
    Optional<Staff> findByName(String name);
}