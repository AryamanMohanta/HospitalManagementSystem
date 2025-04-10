package com.amhospital.HospitalManagementSystem.Config;

import com.amhospital.HospitalManagementSystem.DTO.DoctorDto;
import com.amhospital.HospitalManagementSystem.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    @Mapping(target = "doctor_id", ignore = false)
    Doctor toEntity(DoctorDto doctorDto);

    @Mapping(target = "doctor_id", ignore = false)
    DoctorDto toDto(Doctor doctor);

}
