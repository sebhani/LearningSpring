package com.example.springSecurity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @RequestMapping(value = "")
    public String home(){
        return "<h1>Welcome</h1>";
    }
}
