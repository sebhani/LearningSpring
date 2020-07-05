package com.example.springSecurity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @RequestMapping(value = "")
    public String home(){
        return "<h1>Welcome</h1>";
    }

    @RequestMapping(value = "/admin")
    public String admin(){
        return "<h1>Welcome admin</h1>";
    }

    @RequestMapping(value = "/user")
    public String user(){
        return "<h1>Welcome user</h1>";
    }
}
