package com.example.backend.service;

import com.example.backend.dao.UserDAO;
import com.example.backend.dao.UserRepo;
import com.example.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(@Qualifier("UserRepo") UserDAO userDAO){this.userDAO = userDAO;}
    public int createUser(User user){return userDAO.createUser(user);}
    public int updateUser(String uName, User user){return userDAO.updateUser(uName, user);}
    public int deleteUser(String uName) {return userDAO.deleteUser(uName);}
    public User findUserByName(String uname) {
        return userDAO.findUserByName(uname);
    }
    public List<User> queryUsers(){return userDAO.queryUsers();}
    public Optional<User> queryUser(String uName){return userDAO.queryUser(uName);}
}

