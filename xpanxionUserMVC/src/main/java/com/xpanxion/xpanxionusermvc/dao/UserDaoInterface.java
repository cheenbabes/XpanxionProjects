/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.xpanxionusermvc.dao;

import com.xpanxion.xpanxionusermvc.model.User;
import java.util.List;

/**
 *
 * @author ebaibourine
 */
public interface UserDaoInterface {
    
    List<User> getAllUsers();
    
}
