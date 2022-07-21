package com.example.backend.api;

import com.example.backend.model.User;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="users/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value="", consumes = MediaType.APPLICATION_JSON_VALUE)
    int insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }

    @PutMapping(value="{uname}")
    int updateUser(@PathVariable("uname") String uname,@RequestBody User user){
        return userService.UpdateUser(uname,user);
    }
    @DeleteMapping(value="{uname}")
    int deleteUser(@PathVariable("uname") String uname){
        return userService.deleteUser(uname);
    }
    @GetMapping
    List<User> queryUsers(){
        return userService.queryUsers();
    }
    @GetMapping(value="login/{uname}/{pword}")
    User validateLogin(@PathVariable("uname") String uname,
                       @PathVariable("pword") String pword){
        return userService.validateLogin(uname,pword);
    }
}