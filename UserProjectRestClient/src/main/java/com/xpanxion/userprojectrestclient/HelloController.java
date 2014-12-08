package com.xpanxion.userprojectrestclient;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
        
    public HelloController() {
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index() { 
        return "index";
    }
    
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String helloController(Model model){
        model.addAttribute("message", "Hello from the controller" );
        return "hello";
    }
}
