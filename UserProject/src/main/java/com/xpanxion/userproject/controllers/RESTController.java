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
    
    private UserDao dao;
    
    @Inject
    public RESTController(UserDao dao){
        this.dao = dao;
    }
    
    @RequestMapping(value="/users", method = RequestMethod.GET)
    @ResponseBody public List<User> getAllUsers(){
        return dao.getAllUsers();
    }
    
    @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
    @ResponseBody public User getUser(@PathVariable("id") int id){
        return dao.getUser(id);
    }
    
    @RequestMapping(value="/user", method = RequestMethod.GET)
    @ResponseBody public User getUserRequestParam(@RequestParam("user") int id){
        return dao.getUser(id);
    }
    
    @RequestMapping(value="/user/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putUser(@PathVariable("id") int id, @RequestParam("password") String password){
        dao.updateUser(id, password);
    }
        
    @RequestMapping(value="/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody public User createUser(@RequestParam("USER") String user, @RequestBody User userToCreate){
       dao.addUser(userToCreate);
       return userToCreate;
    }
    
    @RequestMapping(value="user/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") int id){
        dao.deleteUser(id);
    }
    
    
}
