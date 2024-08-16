package org.factoriaf5.zootopia.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
    public String login() {
        return "Login success";
    }

    @PostMapping("/api/v1/logout")
    public String logout() {
        return "Logout success";

    }
}
