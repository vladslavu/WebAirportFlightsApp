package com.utcn.se.project.service;

import com.utcn.se.project.dto.StaffMemberDTO;
import com.utcn.se.project.exception.NotFoundException;
import com.utcn.se.project.mapper.EventStaffAssignationMapper;
import com.utcn.se.project.mapper.StaffMemberMapper;
import com.utcn.se.project.model.EventStaffAssignation;
import com.utcn.se.project.model.StaffMember;
import com.utcn.se.project.repository.StaffMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StaffMemberServiceImpl implements StaffMemberService {

    @Autowired
    private StaffMemberRepository staffMemberRepository;

    @Override
    public StaffMember createStaffMember(StaffMember staffMember) {
        StaffMemberDTO staffMemberDto = StaffMemberMapper.toDTO(staffMember);
        return StaffMemberMapper.toEntity(staffMemberRepository.save(staffMemberDto));
    }

    @Override
    public StaffMember getStaffMemberById(int id) {
        Optional<StaffMemberDTO> staffMemberDto = staffMemberRepository.findById(id);
        if(staffMemberDto.isEmpty()) {
            throw new NotFoundException("The staff member was not found");
        }
        return StaffMemberMapper.toEntity(staffMemberDto.get());
    }

    @Override
    public void deleteStaffMemberById(int id) {
        staffMemberRepository.deleteById(id);
    }

    @Override
    public List<StaffMember> getAllStaffMembers() {
        return staffMemberRepository.findAll().stream().map(StaffMemberMapper::toEntity).collect(Collectors.toList());
    }
}
