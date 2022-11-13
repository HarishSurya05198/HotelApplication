package com.hotel.booking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "app/")
public class LoginController {

    @GetMapping(name = "test")
    public String testApi(){
        return "first springboot application";
    }

}
