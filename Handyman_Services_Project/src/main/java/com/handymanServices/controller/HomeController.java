package com.handymanServices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@CrossOrigin(origins = "http://127.0.0.1:5501")

    @GetMapping("/")
    public String home() {
        return "home"; 
    }
}

