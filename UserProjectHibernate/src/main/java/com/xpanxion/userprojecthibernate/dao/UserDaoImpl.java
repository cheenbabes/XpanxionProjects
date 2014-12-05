/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.userprojecthibernate.dao;

import com.xpanxion.userprojecthibernate.dto.entity.UserEntity;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ebaibourine
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    
    private SessionFactory sessionFactory;
    
    @Inject
    public UserDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    private Session currentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public UserEntity getUser(long userId) {
        return (UserEntity) currentSession().get(UserEntity.class, userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addUser(UserEntity user) {
        currentSession().save(user);
    }

    @Override
    public void updateUser(long userId, String password) {
        UserEntity u = this.getUser(userId);
        u.setPassword(password);
        currentSession().update(u);
    }

    @Override
    public void deleteUser(long userId) {
        UserEntity u = this.getUser(userId);
        currentSession().delete(u);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) currentSession().createCriteria(UserEntity.class).list();
    }
    
}
