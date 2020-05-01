package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model){//Model is to pass data from controller handler to view

        ArrayList<String> cheeses = new ArrayList<String>();
//        cheeses.add("cheddar");
//        cheeses.add("parmesan");
//        cheeses.add("munster");

        //model.addAttribute("cheeses",cheeses);
        model.addAttribute("title","My Cheeses");
        return "cheese/index";
    }
}
