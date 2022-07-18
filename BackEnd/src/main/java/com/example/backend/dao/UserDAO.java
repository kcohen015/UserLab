package com.example.backend.dao;

import com.example.backend.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface UserDAO {

    default int insertUser( User user) {
        Random rand = new Random();
        int uid = rand.nextInt();
        return insertUser(String.valueOf(uid), user);
    }
    int insertUser(String uname, User user);
    int updateUser(String uname, User user);
    int deleteUser(String uname);
    List<User> queryUsers();
    Optional<User> queryUser(String uname);
}

