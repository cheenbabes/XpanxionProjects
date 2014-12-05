/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.userproject.controllers;

import com.xpanxion.userproject.dao.UserDao;
import com.xpanxion.userproject.model.User;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ebaibourine
 */
@Controller
public class UserController {
    
    private UserDao dao;

    @Inject
    public UserController(UserDao dao){
        this.dao = dao;
    }
    
    @RequestMapping(value ="/users", method = RequestMethod.GET)
    public String getUserPage(Model model){
       List<User> userList = dao.getAllUsers();
       model.addAttribute("userList", userList);
        
        return "users";
    }
}
