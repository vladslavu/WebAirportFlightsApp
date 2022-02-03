package com.utcn.se.project.controller;

import com.utcn.se.project.mapper.AirportEventMapper;
import com.utcn.se.project.model.AirportEvent;
import com.utcn.se.project.model.AirportEventStringDate;
import com.utcn.se.project.model.EventStaffAssignation;
import com.utcn.se.project.service.AirportServiceImpl;
import com.utcn.se.project.service.EventStaffAssignationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventManagerController {

    @Autowired
    private EventStaffAssignationServiceImpl eventService;

    @RequestMapping("/eventManagerPage")
    public ModelAndView homePage() {
        return new ModelAndView("eventManagerPage");
    }

    @Autowired
    private AirportServiceImpl airportService;

    @GetMapping("/eventManagerAddEvent")
    public String addEventAsManager(Model model)
    {
        model.addAttribute("event", new AirportEvent());

        return "eventManagerAddEvent";
    }

    @PostMapping("/addEventAsEventManager")
    public String addEvent(AirportEventStringDate event)
    {
        airportService.createAirportEvent(AirportEventMapper.toEntityFromStringDate(event));

        return "redirect:/eventManagerPage";
    }

    @GetMapping("/eventManagerAddEventAssignation")
    public String eventManagerAddEventAssignation(Model model)
    {
        model.addAttribute("event", new EventStaffAssignation());

        return "eventManagerAddEventAssignation";
    }

    @PostMapping("/addEventAssignationAsEventManager")
    public String addEvent(EventStaffAssignation event)
    {
        eventService.createEventStaffAssignation(event);

        return "redirect:/eventManagerPage";
    }
}
