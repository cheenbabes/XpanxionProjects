/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.userprojecthibernate.service;

import com.xpanxion.userprojecthibernate.dto.bean.UserBean;
import com.xpanxion.userprojecthibernate.dto.entity.UserEntity;
import java.util.List;

/**
 *
 * @author ebaibourine
 */
public interface UserServiceDao {

    UserBean getUser(long userId);

    void addUser(UserBean user);

    void updateUser(UserBean user);

    void deleteUser(long userId);

    List<UserBean> getAllUsers();
    
    UserBean convertUserEntityToUserBean(UserEntity entity);
    
    UserEntity convertUserBeanToUserEntity(UserBean bean);

}
