package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping(value = "home")   //will make the path /home/...
public class HelloController {

    //This method is for retrieving data within http requests
    @RequestMapping(value="")
    @ResponseBody
    public String index(HttpServletRequest request){ // To retrieve data from http request, user HttpServletRequest --> .getParameter("name")
        String name = request.getParameter("name");

        if(name == null)
            name = "World!";

        return "Hello "+name;
    }

    //Following two methods are to handle POST requests
    //step #1: handling getting requests by displaying the form to get user input
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html = "<form method='post'>" +
                "<input type='text' name='name'/>" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";

        return html;
    }

    //step #2: retrieving posted data entered by users
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
        String name = request.getParameter("name");

        return "Hello "+name;
    }

    //This method is to handle segment data passing
    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){//parameter should match the one within curly braces (i.e. both 'name')
        return "Hello "+name;
    }

    @RequestMapping(value="goodbye")
    //@ResponseBody //we don't need it because we will redirect
    public String goodBye(){

        return "redirect:/";
    }

}
