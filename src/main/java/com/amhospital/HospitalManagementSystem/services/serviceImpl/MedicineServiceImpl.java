package com.amhospital.HospitalManagementSystem.services.serviceImpl;

import com.amhospital.HospitalManagementSystem.Config.MedicineMapper;
import com.amhospital.HospitalManagementSystem.DTO.MedicineDto;
import com.amhospital.HospitalManagementSystem.model.Medicine;
import com.amhospital.HospitalManagementSystem.repositories.MedicineRepo;
import com.amhospital.HospitalManagementSystem.services.MedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService {
    private static final Logger log = LoggerFactory.getLogger(MedicineService.class);
    @Autowired
    private MedicineRepo medicineRepo;

    @Override
    public MedicineDto addMedicine(MedicineDto medicineDto) {
        Medicine medicine = medicineRepo.save(MedicineMapper.INSTANCE.toEntity(medicineDto));
        log.info("Medicine added successfully with ID: {}", medicine.getMedicineId());
        return MedicineMapper.INSTANCE.toDto(medicine);
    }

    @Override
    public Boolean removeMedicine(Integer medicineId) {
        if (medicineRepo.existsById(medicineId)) {
            medicineRepo.deleteById(medicineId);
            return true;
        }
        throw new RuntimeException("Medicine not found");
    }

    @Override
    public MedicineDto getMedicine(Integer medicineId) {
        return MedicineMapper.INSTANCE.toDto(medicineRepo.findById(medicineId).orElseThrow(() -> new RuntimeException("Medicine not found")));
    }

    @Override
    public MedicineDto updateMedicine(MedicineDto medicineDto) {
        if (medicineRepo.existsById(medicineDto.getMedicineId())) {
            return MedicineMapper.INSTANCE.toDto(medicineRepo.save(MedicineMapper.INSTANCE.toEntity(medicineDto)));
        }
        throw new RuntimeException("Medicine not found");
    }
}