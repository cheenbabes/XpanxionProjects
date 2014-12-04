/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.xpanxionusermvc.dao;

import com.xpanxion.xpanxionusermvc.model.User;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ebaibourine
 */

@Transactional
public class UserDaoHibernateImpl implements UserDaoInterface{
    
    @Override
    public List<User> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
