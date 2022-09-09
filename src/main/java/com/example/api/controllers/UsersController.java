package com.example.api.controllers;

import com.example.api.model.Users;
import com.example.api.services.UsersService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @PostMapping("/item")
    public void add(@RequestBody Users user){
        usersService.add(user);
    }

    @DeleteMapping("/item/{userId}")
    public void delete(@PathVariable Long userId){
        usersService.delete(userId);
    }
    @PutMapping("/item")
    public void update(Users user){
        usersService.update(user);
    }
}
