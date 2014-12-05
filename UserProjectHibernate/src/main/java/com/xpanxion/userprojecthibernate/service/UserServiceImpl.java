/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.userprojecthibernate.service;

import com.xpanxion.userprojecthibernate.dao.UserDao;
import com.xpanxion.userprojecthibernate.dto.bean.UserBean;
import com.xpanxion.userprojecthibernate.dto.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ebaibourine
 */
public class UserServiceImpl implements UserServiceDao {
    
    private UserDao userDao;

    @Inject
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public UserBean getUser(long userId) {
        UserEntity ue = userDao.getUser(userId);
        UserBean ub = this.convertUserEntityToUserBean(ue);
        return ub;
    }

    @Override
    public void addUser(UserBean user) {
        UserEntity ue = this.convertUserBeanToUserEntity(user);
        userDao.addUser(ue);
    }

    @Override
    public void updateUser(long userId, String password) {
        userDao.updateUser(userId, password);
    }

    @Override
    public void deleteUser(long userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public List<UserBean> getAllUsers() {
        List<UserEntity> userEntityList =userDao.getAllUsers();
        List<UserBean> userBeanList = new ArrayList<>();
        for(UserEntity ue : userEntityList){
            UserBean ub = this.convertUserEntityToUserBean(ue);
            userBeanList.add(ub);
        }
        return userBeanList;
    }

    @Override
    public UserBean convertUserEntityToUserBean(UserEntity entity) {
        UserBean ub = new UserBean();
        ub.setId(entity.getId());
        ub.setUsername(entity.getUsername());
        ub.setPassword(entity.getPassword());
        return ub;
    }

    @Override
    public UserEntity convertUserBeanToUserEntity(UserBean bean) {
        UserEntity ue = new UserEntity();
        ue.setId(bean.getId());
        ue.setUsername(bean.getUsername());
        ue.setPassword(bean.getPassword());
        return ue;
    }
    
    
    
}
