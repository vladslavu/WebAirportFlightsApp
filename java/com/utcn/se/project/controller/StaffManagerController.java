package com.utcn.se.project.controller;

import com.utcn.se.project.mapper.AirportEventMapper;
import com.utcn.se.project.model.AirportEventStringDate;
import com.utcn.se.project.model.EventStaffAssignation;
import com.utcn.se.project.model.StaffMember;
import com.utcn.se.project.service.EventStaffAssignationServiceImpl;
import com.utcn.se.project.service.StaffMemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaffManagerController {

    @Autowired
    private EventStaffAssignationServiceImpl eventService;

    @Autowired
    private StaffMemberServiceImpl staffMemberService;

    @RequestMapping("/staffManagerPage")
    public ModelAndView homePage() {
        return new ModelAndView("staffManagerPage");
    }

    @GetMapping("/staffManagerAddStaffMember")
    public String staffManagerAddStaffMember(Model model)
    {
        model.addAttribute("staffMember", new StaffMember());

        return "staffManagerAddStaffMember";
    }

    @PostMapping("/addStaffMemberAsStaffManager")
    public String addStaffMember(StaffMember member)
    {
        staffMemberService.createStaffMember(member);

        return "redirect:/staffManagerPage";
    }

    @GetMapping("/staffManagerAddEventAssignation")
    public String staffManagerAddEventAssignation(Model model)
    {
        model.addAttribute("event", new EventStaffAssignation());

        return "staffManagerAddEventAssignation";
    }

    @PostMapping("/addEventAssignationAsStaffManager")
    public String addEventAssignationAsStaffManager(EventStaffAssignation event)
    {
        eventService.createEventStaffAssignation(event);

        return "redirect:/staffManagerPage";
    }
}
