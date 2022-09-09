package com.example.api.controllers;

import com.example.api.model.Users;
import com.example.api.services.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    private final UsersService usersService;


    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/list")
    public List<Users> list(){
        return usersService.list();
    }

    @PostMapping("/add")
    public void add(@RequestBody Users user){
        usersService.add(user);
    }
}
