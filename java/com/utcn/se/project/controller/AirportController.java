package com.utcn.se.project.controller;

import com.utcn.se.project.model.AirplaneEventFilter;
import com.utcn.se.project.model.AirplaneEventFilterStringDate;
import com.utcn.se.project.model.AirportEvent;
import com.utcn.se.project.service.AirportServiceImpl;
import com.utcn.se.project.service.EventStaffAssignationService;
import com.utcn.se.project.service.StaffMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class AirportController {
    @Autowired
    AirportServiceImpl airportService;

    @Autowired
    StaffMemberService staffMemberService;

    @Autowired
    EventStaffAssignationService eventStaffAssignationService;

    @RequestMapping("/home")
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }

    @RequestMapping("/about")
    public ModelAndView aboutPage() {
        return new ModelAndView("about");
    }

    @RequestMapping("/contact")
    public ModelAndView contactPage() {
        return new ModelAndView("contact");
    }

    @RequestMapping("/airportEvents")
    public String flightsPage(Model model) {
//        model.addAttribute("eventList", AirportServiceImpl.getInstance().getAllAirportEvents());
        model.addAttribute("eventList", airportService.getAllAirportEvents());
        return "airportEvents";
    }

    @RequestMapping("/staffMember")
    public String staffPage(Model model) {
        model.addAttribute("staffList", staffMemberService.getAllStaffMembers());
        return "staffMember";
    }

    @RequestMapping("/eventStaffAssignation")
    public String eventAssignation(Model model) {
        model.addAttribute("eventAssignationList", eventStaffAssignationService.getAllEventStaffAssignation());
        return "eventStaffAssignation";
    }

    @RequestMapping("/addFilter")
    public String addFilter(Model model) {
        model.addAttribute("eventFilter", new AirplaneEventFilterStringDate());
        return "addFilter";
    }

    @PostMapping("/filterList")
    public String filterList(AirplaneEventFilterStringDate filter, Model model) {
        List<AirportEvent> events = airportService.getAllAirportEvents();

        List<AirportEvent> filterList = new ArrayList<>();
        for (AirportEvent event : events) {
            int filteredEvent = 1;
            if (!filter.getEndLocation().isEmpty()) {
                if (!event.getEndLocation().contains(filter.getEndLocation())) {
                    filteredEvent = 0;
                }
            }
            if (!filter.getStartLocation().isEmpty()) {
                if (!event.getStartLocation().contains(filter.getStartLocation())) {
                    filteredEvent = 0;
                }
            }
            if (!filter.getStartDate().isEmpty()) {
                if (event.getStartDate().isBefore(LocalDateTime.parse(filter.getStartDate()))) {
                    filteredEvent = 0;
                }
            }
            if (!filter.getEndDate().isEmpty()) {
                if (event.getEndDate().isBefore(LocalDateTime.parse(filter.getEndDate()))) {
                    filteredEvent = 0;
                }
            }
            if(filteredEvent == 1) {
                filterList.add(event);
            }
        }
        model.addAttribute("eventList", filterList);

        return "filterEventList";
    }
}
