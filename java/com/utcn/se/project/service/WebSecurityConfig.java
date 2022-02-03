package com.utcn.se.project.service;

import javax.sql.DataSource;


import com.utcn.se.project.encoder.PasswordEncoder;
import com.utcn.se.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    @Autowired
    private UserRepository repo;

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder.getEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/adminEventStaffAssignation", "/adminStaffMember", "/adminCreateAccount","/adminPage", "/adminAirportEventPage", "/adminAddEvent","/adminUpdateEvent").hasAuthority("ADMIN")
                .antMatchers("/staffManagerPage", "/staffManagerAddEventAssignation", "/staffManagerAddStaffMember").hasAuthority("STAFF_MANAGER")
                .antMatchers("/eventManagerPage", "/eventManagerAddEventAssignation", "/eventManagerAddEvent", "/eventManagerStaffAssignation").hasAuthority("EVENT_MANAGER")
                .antMatchers("/customerPage", "/customerAirportEvents", "/customerBookedFlight", "filterEventsAsCustomer").hasAuthority("CUSTOMER")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .usernameParameter("username")
                .successHandler((request, response, authentication) -> {
                    CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
                    if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
                        response.sendRedirect("/administratorPage");
                    } else {
                        if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("STAFF_MANAGER"))) {
                            response.sendRedirect("/staffManagerPage");
                        } else {
                            if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("EVENT_MANAGER"))) {
                                response.sendRedirect("/eventManagerPage");
                            } else {
                                if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("CUSTOMER"))) {
                                    response.sendRedirect("/customerPage");
                                }
                            }
                        }
                    }
                })
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/home").permitAll();
    }
}
