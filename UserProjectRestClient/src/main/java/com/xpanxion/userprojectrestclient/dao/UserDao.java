/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.userprojectrestclient.dao;

import com.xpanxion.userprojectrestclient.model.UserBean;
import java.util.List;

/**
 *
 * @author ebaibourine
 */
public interface UserDao {
    
    UserBean getUser(long userId);

    void addUser(UserBean user);

    void updateUser(long userId, String password);

    void deleteUser(long userId);

    List<UserBean> getAllUsers();

}
