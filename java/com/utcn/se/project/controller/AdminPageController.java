package com.utcn.se.project.controller;

import com.utcn.se.project.dto.UserRole;
import com.utcn.se.project.mapper.AirportEventMapper;
import com.utcn.se.project.model.AirportEvent;
import com.utcn.se.project.model.AirportEventStringDate;
import com.utcn.se.project.model.User;
import com.utcn.se.project.service.AirportServiceImpl;
import com.utcn.se.project.service.EventStaffAssignationService;
import com.utcn.se.project.service.StaffMemberService;
import com.utcn.se.project.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPageController {

    @Autowired
    StaffMemberService staffMemberService;

    @Autowired
    private AirportServiceImpl airportService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    EventStaffAssignationService eventStaffAssignationService;

    @RequestMapping("/administratorPage")
    public ModelAndView homePage() {
        return new ModelAndView("administratorPage");
    }

    @RequestMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable(value = "id") int id) {
        airportService.deleteAirportEventById(id);
        return "redirect:/adminAirportEventPage";
    }

    @RequestMapping("/deleteStaffMember/{id}")
    public String deleteStaffMember(@PathVariable(value = "id") int id) {
        staffMemberService.deleteStaffMemberById(id);
        return "redirect:/adminStaffMember";
    }

    @RequestMapping("adminAirportEventPage")
    public String getToAirportEventPage(Model model) {
        model.addAttribute("eventList", airportService.getAllAirportEvents()) ;
        return "/adminAirportEventPage";
    }

    @GetMapping("/adminAddEvent")
    public String signUp(Model model)
    {
        model.addAttribute("event", new AirportEvent());

        return "adminAddEvent";
    }

    @PostMapping("/addEventAsAdmin")
    public String addEvent(AirportEventStringDate event)
    {
        airportService.createAirportEvent(AirportEventMapper.toEntityFromStringDate(event));
        return "redirect:/adminAirportEventPage";
    }

    //  NEW
    @RequestMapping("/adminStaffMember")
    public String adminStaffMember(Model model) {
        model.addAttribute("staffList", staffMemberService.getAllStaffMembers()) ;
        return "adminStaffMember";
    }

    @RequestMapping("/adminEventStaffAssignation")
    public String adminEventStaffAssignation(Model model) {
        model.addAttribute("eventAssignationList", eventStaffAssignationService.getAllEventStaffAssignation()) ;
        return "adminEventStaffAssignation";
    }

    @PostMapping("/adminProcessRegister")
    public String adminProcessRegister(User user) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        try {
            userService.createUser(user);
        } catch(Exception exception) {
            return "adminCreateAccount";
        }

        return "redirect:/adminCreateAccount";
    }

    @GetMapping("/adminCreateAccount")
    public String adminCreateAccount(Model model)
    {
        model.addAttribute("user", new User());

        return "adminCreateAccount";
    }

    @GetMapping("/updateEvent/{id}")
    public String updateEvent(@PathVariable(value = "id") int id, Model model) {
        AirportEvent event = airportService.getAirportEventById(id);

        model.addAttribute("event", AirportEventMapper.toStringDateFromEntity(event));
        return "adminUpdateEvent";
    }
}
