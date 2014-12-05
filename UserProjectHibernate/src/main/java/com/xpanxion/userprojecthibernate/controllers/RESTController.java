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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author ebaibourine
 */
@Controller
@RequestMapping("/rest")
public class RESTController {
    
    private UserServiceDao userService;
    
    @Inject
    public RESTController(UserServiceDao userService){
        this.userService = userService;
    }
    
    @RequestMapping(value="/users", method = RequestMethod.GET)
    @ResponseBody public List<UserBean> getAllUsers(){
        return userService.getAllUsers();
    }
    
    @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
    @ResponseBody public UserBean getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }
    
    @RequestMapping(value="/user", method = RequestMethod.GET)
    @ResponseBody public UserBean getUserRequestParam(@RequestParam("user") int id){
        return userService.getUser(id);
    }
    
    @RequestMapping(value="/user/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putUser(@PathVariable("id") int id, @RequestParam("password") String password){
        userService.updateUser(id, password);
    }
        
    @RequestMapping(value="/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody public UserBean createUser(@RequestParam("USER") String user, @RequestBody UserBean userToCreate){
       userService.addUser(userToCreate);
       return userToCreate;
    }
    
    @RequestMapping(value="user/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }
    
    
}
