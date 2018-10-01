package com.protean.legislativetracker.legislativetrackerserverservicerest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/states")
@Controller
public class StateController {

    @RequestMapping("")
    public String listOfStates() {
        return "states/states";
    }
    
}
