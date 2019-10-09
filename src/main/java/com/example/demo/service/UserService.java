package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer save(User user) {
        return userRepository.save(user).getId();
    }

    public User findOne(Integer userID) {
        return userRepository.findById(userID).orElse(null);
    }

    public User update(User user) {

        //User userToUpdate = userRepository.getOne(user.getId());
        return userRepository.save(user);
    }

}
