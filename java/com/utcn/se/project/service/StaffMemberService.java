package com.utcn.se.project.service;

import com.utcn.se.project.model.EventStaffAssignation;
import com.utcn.se.project.model.StaffMember;

import java.util.List;

public interface StaffMemberService {

    StaffMember createStaffMember(StaffMember staffMember);

    StaffMember getStaffMemberById(int id);

    public void deleteStaffMemberById(int id);

    List<StaffMember> getAllStaffMembers();

}
