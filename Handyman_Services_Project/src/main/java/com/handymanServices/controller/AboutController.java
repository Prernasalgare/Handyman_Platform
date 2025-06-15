package com.handymanServices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
@CrossOrigin(origins = "http://127.0.0.1:5501")
@Controller
public class AboutController {

    @GetMapping("/about")
    public String showAboutPage() {
        return "about"; 
    }
}
