package com.javaschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/doggo")
    public String showDoggoPage() {
        return "doggo";
    }

    @GetMapping("/admin/admin-page")
    public String showAdminPage() {
        return "admin-page";
    }

    @GetMapping("/login-page")
    public String showLoginPage() {
        return "login-page";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

}
