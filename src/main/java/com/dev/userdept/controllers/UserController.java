package com.dev.userdept.controllers;

import com.dev.userdept.entities.User;
import com.dev.userdept.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    public User Insert(@RequestBody User user) {
        User resultCreate = repository.save(user);
        return resultCreate;
    }

    @GetMapping
    public List<User> findAll() {
        List<User> resultAll = repository.findAll();
        return resultAll;
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        User resultId = repository.findById(id).get();
        return resultId;
    }
}
