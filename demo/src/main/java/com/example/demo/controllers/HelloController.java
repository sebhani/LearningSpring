package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping(value = "home")   //will make the path /home/...
public class HelloController {

    @RequestMapping(value="")
    @ResponseBody
    public String index(HttpServletRequest request){ // To retrieve data from http request, user HttpServletRequest --> .getParameter("name")
        String name = request.getParameter("name");

        if(name == null)
            name = "World!";

        return "Hello "+name;
    }

    @RequestMapping(value="goodbye")
    @ResponseBody
    public String goodBye(){
        return "Goodbye";
    }

}
