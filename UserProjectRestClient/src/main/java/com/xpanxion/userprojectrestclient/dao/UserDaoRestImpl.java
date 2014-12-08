/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.userprojectrestclient.dao;

import com.xpanxion.userprojectrestclient.model.UserBean;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ebaibourine
 */
public class UserDaoRestImpl implements UserDao {

    private final String baseUrl = "http://localhost:8080/UserProjectHibernate/rest/";
    private RestTemplate rt;

    private void setUpRestTemplate() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJacksonHttpMessageConverter());
        this.rt.setMessageConverters(converters);

    }

    @Override
    public UserBean getUser(long userId) {
        this.setUpRestTemplate();
        String url = baseUrl + userId;
        return rt.getForObject(url, UserBean.class);
    }

    @Override
    public void addUser(UserBean user) {
        this.setUpRestTemplate();
        String url = baseUrl + "user";
        rt.postForObject(url, user, UserBean.class);
    }

    @Override
    public void updateUser(long userId, String password) {
        this.setUpRestTemplate();
        String url = baseUrl + "user/" + userId;
        UserBean u = this.getUser(userId);
        u.setPassword(password);
        rt.put(url, u);
    }

    @Override
    public void deleteUser(long userId) {
        this.setUpRestTemplate();
        String url = baseUrl + "user/" + userId;
        rt.delete(url);
    }

    @Override
    public List<UserBean> getAllUsers() {
        this.setUpRestTemplate();
        String url = baseUrl + "users";
        return rt.getForObject(url, ArrayList.class);
    }

}
