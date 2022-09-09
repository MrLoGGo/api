package com.example.api.services;

import com.example.api.model.Users;
import com.example.api.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        if(usersRepository.findUsersByLogin(user.getLogin()).isPresent()){
            throw new IllegalStateException("Login is busy");
        }
        usersRepository.save(user);
    }

    public void delete(Long id){
        usersRepository.deleteById(id);
    }

    public void update(Users user) {
        Optional<Users> row = usersRepository.findById(user.getId());
        if(row.isPresent()){
            Users item = row.get();
            if(!user.getLogin().isEmpty()){
                item.setLogin(user.getLogin());
            }
            if(!user.getPassword().isEmpty()){
                item.setPassword(user.getPassword());
            }
            usersRepository.save(item);
        }
    }
}
