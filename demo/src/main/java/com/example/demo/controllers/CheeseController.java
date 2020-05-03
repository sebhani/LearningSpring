package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model){//Model is to pass data from controller handler to view

        model.addAttribute("cheeses",cheeses);
        model.addAttribute("title","My Cheeses");
        return "cheese/index";
    }

    /**
    * render the add cheese form
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title","Add Cheese");
        return "cheese/add";
    }

    /**
     * Add cheese form handling
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription){
        cheeses.put(cheeseName, cheeseDescription);

        // Redirect to /cheese. This works because both are within the same controller
        return "redirect:";
    }
}
