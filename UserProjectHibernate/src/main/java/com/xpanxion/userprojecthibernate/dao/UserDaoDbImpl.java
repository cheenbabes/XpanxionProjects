/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.userprojecthibernate.dao;

import com.xpanxion.userprojecthibernate.dto.entity.Authority;
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
public class UserDaoDbImpl implements UserDao {
    
    private SessionFactory sessionFactory;
    
    @Inject
    public UserDaoDbImpl(SessionFactory sessionFactory){
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
        //enable the new user in Spring security
        user.setEnabled(1);
        currentSession().save(user);
        //create an authority entry for the new user and make it valid
        Authority a = new Authority();
        a.setUsername(user.getUsername());
        a.setAuthority("ROLE_USER");
        currentSession().save(a);
    }

    @Override
    public void updateUser(UserEntity user) {
        currentSession().update(user);
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
