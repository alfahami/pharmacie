package com.pharma.pharmacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PharmaController {
    
    @GetMapping("/")
    public String getForm() {
        return "home";
    }
}
