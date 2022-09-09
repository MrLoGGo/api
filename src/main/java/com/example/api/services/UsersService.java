package com.example.api.services;

import com.example.api.model.Users;
import com.example.api.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> list(){
        return usersRepository.findAll();
    }
    public void add(Users user){
        usersRepository.save(user);
    }
}
