package com.xpanxion.userprojectrestclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
        
    public HomeController() {
    }
    
    @RequestMapping(value={"/","/index"}, method=RequestMethod.GET)
    public String index() { 
        return "index";
    }
    
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String helloController(Model model){
        model.addAttribute("message", "Welcome to the home page");
        return "hello";
    }
}
