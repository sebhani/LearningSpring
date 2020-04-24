package com.example.coronavirustracker.controllers;

import com.example.coronavirustracker.services.ConronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    ConronaVirusDataService conronaVirusDataService;

    @GetMapping("/")
    public String Home(Model model){
        model.addAttribute("locationStats", conronaVirusDataService.getAllStats());
        return "home";
    }
}
