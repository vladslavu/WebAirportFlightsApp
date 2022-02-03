package com.utcn.se.project.controller;

import com.utcn.se.project.dto.UserDTO;
import com.utcn.se.project.model.AirplaneEventFilterStringDate;
import com.utcn.se.project.model.AirportEvent;
import com.utcn.se.project.model.Ticket;
import com.utcn.se.project.model.User;
import com.utcn.se.project.service.AirportServiceImpl;
import com.utcn.se.project.service.TicketService;
import com.utcn.se.project.service.TicketServiceImpl;
import com.utcn.se.project.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Controller
public class CustomerController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TicketServiceImpl ticketService;

    @Autowired
    private AirportServiceImpl airportService;

    @RequestMapping("/customerPage")
    public ModelAndView homePage() {
        return new ModelAndView("customerPage");
    }

    @RequestMapping("/customerBookedFlight")
    public String customerBookedFlight(Model model) {
        List<Ticket> tickets = ticketService.getAllTickets();
        List<Ticket> ticketsForUser = new ArrayList<>();
        int userId = getUserId();
        for (Ticket ticket : tickets) {
            if (ticket.getIdUser() == userId) {
                ticketsForUser.add(ticket);
            }
        }
        model.addAttribute("ticketList", ticketsForUser);

        return "customerBookedFlight";
    }

    @RequestMapping("/customerAirportEvents")
    public String eventAssignation(Model model) {
        List<AirportEvent> events = airportService.getAllAirportEvents();

        List<AirportEvent> onlyCustomerEvents = new ArrayList<>();
        for(AirportEvent event : events) {
            if(Objects.equals(event.getType().asString(), "FLIGHT")) {
                onlyCustomerEvents.add(event);
            }
        }
        model.addAttribute("eventList", onlyCustomerEvents);

        return "customerAirportEvents";
    }

    @RequestMapping("/bookFlight/{id}")
    public String bookFlight(@PathVariable(value = "id") int id) {
        AirportEvent event = airportService.getAirportEventById(id);
        Random random = new Random();
        Ticket ticket = new Ticket.TicketBuilder()
                .idEvent(id)
                .idUser(getUserId())
                .price(random.nextInt(50) + event.getNumberOfPassengers())
                .build();

        ticketService.createTicket(ticket);
        return "redirect:/customerBookedFlight";
    }

    private int getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.getUserByUsername(currentPrincipalName);

        return user.getIdUser();
    }

    @RequestMapping("/addFilterForCustomer")
    public String addFilter(Model model) {
        model.addAttribute("eventFilter", new AirplaneEventFilterStringDate());
        return "addFilterForCustomer";
    }

    @PostMapping("/filterListForCustomer")
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

        return "filterEventListAsCustomer";
    }
}
