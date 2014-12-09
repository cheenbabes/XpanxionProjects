/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.userprojecthibernate.dao;

import com.xpanxion.userprojecthibernate.dto.entity.UserEntity;
import java.util.List;

/**
 *
 * @author ebaibourine
 */
public interface UserDao {

    UserEntity getUser(long userId);

    void addUser(UserEntity user);

    void updateUser(UserEntity user);

    void deleteUser(long userId);

    List<UserEntity> getAllUsers();
}
