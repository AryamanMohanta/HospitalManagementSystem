package com.amhospital.HospitalManagementSystem.Config;

import com.amhospital.HospitalManagementSystem.DTO.MedicineDto;
import com.amhospital.HospitalManagementSystem.model.Medicine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface MedicineMapper {
    MedicineMapper INSTANCE = Mappers.getMapper(MedicineMapper.class);

    @Mapping(target="medicineId", ignore = false)
    Medicine toEntity(MedicineDto medicineDTO);

    @Mapping(target = "medicineId", ignore = false)
    MedicineDto toDto(Medicine medicine);
}
