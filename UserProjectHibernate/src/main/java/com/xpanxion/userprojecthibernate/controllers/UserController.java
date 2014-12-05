/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.userprojecthibernate.controllers;

import com.xpanxion.userprojecthibernate.dto.bean.UserBean;
import com.xpanxion.userprojecthibernate.service.UserServiceDao;
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
    
    private UserServiceDao userService;

    @Inject
    public UserController(UserServiceDao userService){
        this.userService= userService;
    }

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    public String getUserPage(Model model){
       List<UserBean> userList = userService.getAllUsers();
       model.addAttribute("userList", userList);
        
        return "users";
    }
}
