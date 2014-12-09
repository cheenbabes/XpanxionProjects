/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.userprojectrestclient;

import com.xpanxion.userprojectrestclient.dao.UserDao;
import com.xpanxion.userprojectrestclient.model.User;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ebaibourine
 */
public class RestClientDaoTest {

    UserDao dao;
    User u1;
    User u2;

    public RestClientDaoTest() {
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
        dao = (UserDao) ctx.getBean("userDao");

        u1 = new User();
        u1.setUsername("user1");
        u1.setPassword("user1Password");

        u2 = new User();
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
    
//    @Test
    public void addGetDeleteUser(){
        User u = dao.getUser(31);
        
    }
}
