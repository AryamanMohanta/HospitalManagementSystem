package com.amhospital.HospitalManagementSystem.Config;

import com.amhospital.HospitalManagementSystem.DTO.PatientDto;
import com.amhospital.HospitalManagementSystem.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    @Mapping(target = "patientId", ignore = false)
    Patient toEntity(PatientDto patientDto);

    @Mapping(target = "patientId", ignore = false)
    PatientDto toDto(Patient patient);
}
