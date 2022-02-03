package com.utcn.se.project.controller;

import com.utcn.se.project.dto.UserRole;
import com.utcn.se.project.model.*;
import com.utcn.se.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.utcn.se.project.decoder.JWTDecoder.getUserRoleFromToken;

@RestController
@RequestMapping(path = "/airport")
public class AirplaneController {

    @Autowired
    AirportServiceImpl airportService;

    @Autowired
    TicketServiceImpl ticketService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    StaffMemberServiceImpl staffMemberService;

    @Autowired
    EventStaffAssignationServiceImpl eventStaffAssignationService;

    @GetMapping("/{id}")
    public ResponseEntity<AirportEvent> findById(@PathVariable(value = "id") int id, @RequestHeader(value = "jwt") String header) {
        if (isAllowed(header, List.of(UserRole.ADMIN, UserRole.STAFF_MANAGER, UserRole.EVENT_MANAGER))) {
            return new ResponseEntity<>(airportService.getAirportEventById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/create")
    public ResponseEntity<AirportEvent> createEvent(@RequestBody AirportEvent airportEvent, @RequestHeader(value = "jwt") String header) {
        if (isAllowed(header, List.of(UserRole.ADMIN, UserRole.STAFF_MANAGER))) {
            return new ResponseEntity<>(airportService.createAirportEvent(airportEvent), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable(value = "id") int id, @RequestHeader(value = "jwt") String header) {
        if (isAllowed(header, List.of(UserRole.ADMIN))) {
            airportService.deleteAirportEventById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AirportEvent>> findAll() {
        return new ResponseEntity<>(airportService.getAllAirportEvents(), HttpStatus.OK);
    }

    @PostMapping("/ticket/create")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket, @RequestHeader(value = "jwt") String header) {
        if (isAllowed(header, List.of(UserRole.CUSTOMER))) {
            return new ResponseEntity<>(ticketService.createTicket(ticket), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> findTicketById(@PathVariable(value = "id") int id, @RequestHeader(value = "jwt") String header) {
        if (isAllowed(header, List.of(UserRole.CUSTOMER))) {
            return new ResponseEntity<>(ticketService.getTicketById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/staff/create")
    public ResponseEntity<StaffMember> createStaffMember(@RequestBody StaffMember staffMember, @RequestHeader(value = "jwt") String header) {
        if (isAllowed(header, List.of(UserRole.ADMIN, UserRole.STAFF_MANAGER))) {
            return new ResponseEntity<>(staffMemberService.createStaffMember(staffMember), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<StaffMember> findStaffMemberById(@PathVariable(value = "id") int id, @RequestHeader(value = "jwt") String header) {
        if (isAllowed(header, List.of(UserRole.ADMIN, UserRole.STAFF_MANAGER))) {
            return new ResponseEntity<>(staffMemberService.getStaffMemberById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setRole(UserRole.GUEST);
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/admin/user/create")
    public ResponseEntity<User> createUserByAdmin(@RequestBody User user, @RequestHeader(value = "jwt") String header) {
        if (isAllowed(header, List.of(UserRole.ADMIN))) {
            return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") int id, @RequestHeader(value = "jwt") String header) {
        if (isAllowed(header, List.of(UserRole.ADMIN))) {
            return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/staff_event/create")
    public ResponseEntity<EventStaffAssignation> createEventStaffAssignation(@RequestBody EventStaffAssignation eventStaffAssignation, @RequestHeader(value = "jwt") String header) {
        if (isAllowed(header, List.of(UserRole.ADMIN, UserRole.EVENT_MANAGER, UserRole.STAFF_MANAGER))) {
            return new ResponseEntity<>(eventStaffAssignationService.createEventStaffAssignation(eventStaffAssignation), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/staff_event/{id}")
    public ResponseEntity<EventStaffAssignation> findEventStaffAssignation(@PathVariable(value = "id") int id, @RequestHeader(value = "jwt") String header) {
        if (isAllowed(header, List.of(UserRole.ADMIN, UserRole.EVENT_MANAGER, UserRole.STAFF_MANAGER))) {
            return new ResponseEntity<>(eventStaffAssignationService.getEventStaffAssignationById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createUserAuthenticationToken(@RequestBody AuthenticationRequest request) {
        return new ResponseEntity<>(userService.createUserAuthenticationToken(request), HttpStatus.OK);
    }

    private boolean isAllowed(String header, List<UserRole> roleList) {
        return roleList.contains(getUserRoleFromToken(header));
    }
}
