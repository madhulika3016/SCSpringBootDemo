package com.springsecuritybasicdemo;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final HttpSession httpSession;

    public LoginController(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @GetMapping("/api/hello")
    @Secured("USER")
    public String hello() {
        return "Hello, authenticated user!";
    }
    @GetMapping("/api/login")
    @Secured("ADMIN")
    public String login() {
        return "Hello, Admin!";
    }
    @GetMapping("/api/logout")
    @Secured({"ADMIN","USER"})
    public String logout() {
        httpSession.invalidate();
        return "Logged out";
    }
}
