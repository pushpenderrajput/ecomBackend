package com.pushpender.ecombackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String Home(){
        return "HELLO Doston!!";
    }


}
