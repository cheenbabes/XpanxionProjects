/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.userprojecthibernate;

import com.xpanxion.userprojecthibernate.dao.UserDao;
import com.xpanxion.userprojecthibernate.dto.entity.UserEntity;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ebaibourine
 */
public class UserDaoTest {
    
    UserDao dao;
    UserEntity u1;
    UserEntity u2;
    
    public UserDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        JdbcTemplate cleaner = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        cleaner.execute("delete from users");
        cleaner.execute("delete from authorities");
        
        dao = (UserDao) ctx.getBean("userDao");
        
        u1 = new UserEntity();
        u1.setUsername("user1");
        u1.setPassword("user1Password");
        
        u2 = new UserEntity();
        u2.setUsername("user2");
        u2.setPassword("user2Password");
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void addGetDeleteUser(){
        //Add user
        dao.addUser(u1);
        
        UserEntity userFromDb = dao.getUser(u1.getId());
        assertEquals(u1, userFromDb);
        
        dao.deleteUser(u1.getId());
        assertNull(dao.getUser(u1.getId()));
        
    }
    
    @Test
    public void getAllUsers(){
        //Add users to the database
        dao.addUser(u1);
        dao.addUser(u2);
        
        List<UserEntity> userList = dao.getAllUsers();
        assertEquals(userList.size(), 2);
        assertTrue(userList.contains(u1));
        assertTrue(userList.contains(u2));
    }
    
    @Test
    public void updateUser(){
        dao.addUser(u1);
        dao.updateUser(u1.getId(), "newPassword");
        
        UserEntity userFromDb = dao.getUser(u1.getId());
        assertEquals(userFromDb.getPassword(), "newPassword");
        
    }
    
}
