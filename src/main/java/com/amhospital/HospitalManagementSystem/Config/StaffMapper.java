package com.amhospital.HospitalManagementSystem.Config;

import com.amhospital.HospitalManagementSystem.DTO.StaffDto;
import com.amhospital.HospitalManagementSystem.model.Staff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StaffMapper {
    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    @Mapping(target = "doctorId", ignore = false)
    Staff toEntity(StaffDto doctorDto);

    @Mapping(target = "doctorId", ignore = false)
    StaffDto toDto(Staff staff);

}
