package com.login.app.controller;

import com.login.app.dto.UserPostDTO;
import com.login.app.entity.User;
import com.login.app.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login-app/")
    public String startPage() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/login-app/registration")
    public String registrationPage(Model model) {
        model.addAttribute("user", new UserPostDTO());
        return "registration";
    }

    @PostMapping("/login-app/registration")
    public String register(@ModelAttribute @Valid UserPostDTO userPostDTO) {
        User user = userService.addNewUser(userPostDTO);
        userService.loginUser(user);
        return "redirect:/login-app/welcome";
    }

    @GetMapping("/login-app/welcome")
    @PreAuthorize("hasAuthority('USER')")
    public String profilePage(Model model) {
        model.addAttribute("user", userService.getAuthorizedPersonGetDTO());
        return "welcome";
    }

    @GetMapping("/login-app/admin-panel")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String list(Model model) {
        model.addAttribute("users", userService.getAllPersons());
        model.addAttribute("userCount", userService.getAllPersons().size());
        return "admin-panel";
    }

}
