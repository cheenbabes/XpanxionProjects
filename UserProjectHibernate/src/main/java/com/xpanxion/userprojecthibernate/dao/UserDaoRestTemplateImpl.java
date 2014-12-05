/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.userprojecthibernate.dao;

import com.xpanxion.userprojecthibernate.dto.bean.UserBean;
import com.xpanxion.userprojecthibernate.dto.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ebaibourine
 */
public class UserDaoRestTemplateImpl implements UserDao {

    private RestTemplate rt = new RestTemplate();
    private String baseUrl ="http://localhost:8080/UserProjectHibernate/rest";

    private void configureRestTemplate() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJacksonHttpMessageConverter a = new MappingJacksonHttpMessageConverter();
        messageConverters.add(a);
        rt.setMessageConverters(messageConverters);
    }

    @Override
    public UserEntity getUser(long userId) {
        return null;
    }

    @Override
    public void addUser(UserEntity user) {
        this.configureRestTemplate();
        String url = baseUrl + "user/";
        rt.postForObject(url, user, UserEntity.class);
    }

    @Override
    public void updateUser(long userId, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(long userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserEntity> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
