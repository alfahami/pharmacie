package com.pharma.pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pharma.pharmacy.pojo.Drug;
import com.pharma.pharmacy.service.PharmaService;


import jakarta.validation.Valid;

@Controller
public class PharmaController {
    
    @Autowired
    PharmaService pharmaService;

    @GetMapping("/home")
    public String getDrugs(Model model) {
        model.addAttribute("drugs", pharmaService.getDrugs());
        return "home";
    }
    
    @GetMapping("/")
    public String getHome() {
        return "redirect:/home";
    }

    @GetMapping("/addDrug")
    public String getForm(Model model) {
        model.addAttribute("drug", new Drug());
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Drug drug, BindingResult bindingResult) {

         if(bindingResult.hasErrors()) return "form";
         pharmaService.add(drug);
        return "redirect:/home";

    }
}
