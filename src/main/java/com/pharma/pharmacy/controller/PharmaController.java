package com.pharma.pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pharma.pharmacy.pojo.Drug;
import com.pharma.pharmacy.service.PharmaService;

import jakarta.validation.Valid;

@Controller
public class PharmaController {

    @Autowired
    PharmaService pharmaService;

    @GetMapping("/drugs")
    public String getDrugs(Model model) {
        model.addAttribute("drugs", pharmaService.getDrugs());
        return "home";
    }

    @GetMapping("/")
    public String getHome() {
        return "redirect:/drugs";
    }

    @GetMapping("/addDrug")
    public String getForm(Model model) {
        model.addAttribute("drug", new Drug());
        return "form";
    }

    @GetMapping("/editDrug")
    public String editDrug(Model model, @RequestParam(required = true) String id) {
        model.addAttribute("drug", pharmaService.getDrugById(id));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Drug drug, BindingResult bindingResult) {
        if (pharmaService.isDrugAdded(drug.getName()))

           //(Because it stops the update) bindingResult.rejectValue("name", "", "Drug name already exist");
        if (bindingResult.hasErrors())
            return "form";
        pharmaService.submitForm(drug);
        return "redirect:/drugs";

    }
}
