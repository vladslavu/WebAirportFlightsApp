package com.utcn.se.project.controller;

import com.utcn.se.project.dto.UserRole;
import com.utcn.se.project.model.User;
import com.utcn.se.project.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/processRegister")
    public String processRegister(User user) {

        user.setRole(UserRole.CUSTOMER);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        try {
            userService.createUser(user);
        } catch(Exception exception) {
            return "signUpPage";
        }

        return "redirect:/home";
    }

    @GetMapping("/signUpPage")
    public String signUp(Model model)
    {
        model.addAttribute("user", new User());

        return "signUpPage";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
