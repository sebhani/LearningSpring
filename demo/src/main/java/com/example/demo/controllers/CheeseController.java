package com.example.demo.controllers;

import com.example.demo.models.Cheese;
import com.example.demo.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model){//Model is to pass data from controller handler to view

        model.addAttribute("cheeses", CheeseData.getAll());
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
    public String processAddCheeseForm(@ModelAttribute Cheese newCheese){
        //Cheese newCheese = new Cheese(cheeseName,cheeseDescription); //used with @RequestParam annotation
        /*
         * Cheese newCheese = new Cheese();
         * newCheese.setName(Request.getParameter("name"))
         * newCheese.setDescription(Request.getParameter("description"))
         */
        CheeseData.add(newCheese);

        // Redirect to /cheese. This works because both are within the same controller
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveForm(Model model){
        model.addAttribute("title","Remove Cheese");
        model.addAttribute("cheeses",CheeseData.getAll());

        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String RemoveCheeseForm(@RequestParam int[] cheeseIds){

        for(int cheeseId: cheeseIds){
            CheeseData.remove(cheeseId);
        }
        return "redirect:";
    }
}
