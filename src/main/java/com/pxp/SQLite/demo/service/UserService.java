package com.pxp.SQLite.demo.service;

import com.pxp.SQLite.demo.entity.Student;
import com.pxp.SQLite.demo.entity.User;
import com.pxp.SQLite.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public String createUser(User user){
        userRepository.save(user);
        return "Saved";
    }

    public List<User> readUsers(){
        return userRepository.findAll();
    }
}
