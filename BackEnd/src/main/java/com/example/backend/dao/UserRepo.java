package com.example.backend.dao;

import com.example.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("UserRepo")
public class UserRepo implements UserDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static List<User> users = new ArrayList<>();

    @Override
    public int insertUser(String uName, User user) {
        String sql = "INSERT INTO USERS (UNAME, PWORD) VALUES (?,?)";
        return jdbcTemplate.update(sql, new Object[]{user.getuName(), user.getpWord()});
    }

    @Override
    public int updateUser(String uName, User user) {
        String sql = "UPDATE USERS SET UID=?, PWORD=? WHERE UNAME=?";
        return jdbcTemplate.update(sql, new Object[]{user.getId(), user.getpWord(), uName});
    }

    @Override
    public int deleteUser(String uName) {
        String sql = "DELETE FROM USERS WHERE UNAME=?";
        return jdbcTemplate.update(sql, uName);
    }

    @Override
    public List<User> queryUsers() {
        String sql = "SELECT * FROM USERS";
        return jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public Optional<User> queryUser(String uName) {
        User user = null;
        try {
            String sql = "SELECT * FROM USERS WHERE UNAME=?";
            user = jdbcTemplate.queryForObject(sql,
                    BeanPropertyRowMapper.newInstance(User.class), uName);
            return Optional.ofNullable(user);
        } catch (IncorrectResultSizeDataAccessException e) {
            return Optional.ofNullable(user);
        }
    }
}
