/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.userproject;

import java.util.List;

/**
 *
 * @author ebaibourine
 */
public interface UserDao {
    
    User getUser(long userId);
    
    User addUser(User user);
    
    void updateUser(long userId, String password);
    
    void deleteUser(long userId);
    
    List<User> getAllUsers();
}
