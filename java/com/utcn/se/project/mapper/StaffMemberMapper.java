package com.utcn.se.project.mapper;

import com.utcn.se.project.dto.StaffMemberDTO;
import com.utcn.se.project.model.StaffMember;

public class StaffMemberMapper {

    public static StaffMember toEntity(StaffMemberDTO staffMemberDTO) {
        return new StaffMember.StaffMemberBuilder()
                .idStaffMember(staffMemberDTO.getIdStaffMember())
                .firstName(staffMemberDTO.getFirstName())
                .lastName(staffMemberDTO.getLastName())
                .age(staffMemberDTO.getAge())
                .nationality(staffMemberDTO.getNationality())
                .workExperience(staffMemberDTO.getWorkExperience())
                .build();
    }

    public static StaffMemberDTO toDTO(StaffMember staffMember) {
        return new StaffMemberDTO.StaffMemberBuilder()
                .idStaffMember(staffMember.getIdStaffMember())
                .firstName(staffMember.getFirstName())
                .lastName(staffMember.getLastName())
                .age(staffMember.getAge())
                .nationality(staffMember.getNationality())
                .workExperience(staffMember.getWorkExperience())
                .build();
    }
}
