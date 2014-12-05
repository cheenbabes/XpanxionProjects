package com.xpanxion.userprojecthibernate.controllers;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
        
    public HelloController() {
    }
    
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String sayHi(Map<String, Object> model) {
        model.put("message", "Hello from the controller" );
        return "hello";
    }
    
    @RequestMapping(value ={"/","/index"}, method=RequestMethod.GET)
    public String getIndex(){
        return "index";
    }
}
