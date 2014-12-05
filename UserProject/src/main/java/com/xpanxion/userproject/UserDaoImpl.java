/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpanxion.userproject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ebaibourine
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
   
    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(SQL_GET_ALL_USERS, new UserMapper());
    }

    @Override
    public User getUser(long userId) {
        try{
            return jdbcTemplate.queryForObject(SQL_GET_USER_BY_ID, new UserMapper(), userId);
        }catch(EmptyResultDataAccessException e){
            //no matching contact
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly= false)
    public User addUser(User user) {
        jdbcTemplate.update(SQL_INSERT_USER,
                user.getUsername(),
                user.getPassword(),
                1);
        user.setUserId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        //write the security entries to the database
        jdbcTemplate.update(SQL_INSERT_AUTHORITIES,
                user.getUsername(),
                "ROLE_USER");
        
        return this.getUser(user.getUserId());
    }

    @Override
    public void updateUser(long userId, String password) {
        jdbcTemplate.update(SQL_UPDATE_USER,
               password,
               userId);
        
    }

    @Override
    public void deleteUser(long userId) {
        jdbcTemplate.update(SQL_DELETE_USER, userId);
    }
    
        
    private static final String SQL_GET_ALL_USERS =
            "select * from users";
    private static final String SQL_GET_USER_BY_ID =
            "select * from users where id = ?";
    private static final String SQL_UPDATE_USER =
            "update users set password = ? where id = ?";
    private static final String SQL_DELETE_USER =
            "delete from users where id =?";
    private static final String SQL_INSERT_USER =
            "insert into users (username, password, enabled) values (?,?,?)";
    private static final String SQL_INSERT_AUTHORITIES =
            "insert into authorities (username, authority) values(?,?)";
    
    private static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User u = new User();
            u.setUserId(rs.getInt("id"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            
            return u;
        }
        
    }
    
}
