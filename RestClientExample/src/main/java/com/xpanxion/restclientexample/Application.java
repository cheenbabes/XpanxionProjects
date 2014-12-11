/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.restclientexample;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ebaibourine
 */
public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        User u = new User();
        u.setUsername("MyFirstUser");
        u.setPassword("myPassword");
        u =app.createUser(u);
//        User getUser = app.getUser(37);
//        System.out.println("this users password is " + getUser.getPassword());
        System.out.println("the id of the created user is " + u.getId());

    }

    public User createUser(User user) {
        RestTemplate rt = new RestTemplate();
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJacksonHttpMessageConverter());
        rt.setMessageConverters(converters);
        return rt.postForObject("http://localhost:8080/UserProjectHibernate/rest/user", user, User.class);
    }

    public User getUser(long userId) {
        RestTemplate rt = new RestTemplate();
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJacksonHttpMessageConverter());
        rt.setMessageConverters(converters);
        return rt.getForObject("http://localhost:8080/UserProjectHibernate/rest/user/" + userId, User.class);
    }
}
