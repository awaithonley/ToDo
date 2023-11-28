package com.honley.ToDo.service;

import com.honley.ToDo.entity.UserEntity;
import com.honley.ToDo.exception.UserAlreadyExistException;
import com.honley.ToDo.exception.UserNotFoundException;
import com.honley.ToDo.model.User;
import com.honley.ToDo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException{
        if (userRepository.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("Пользователь уже существует !");
        }
        return userRepository.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("Пользователь не был найден");
        }
        return User.toModel(user.get());
    }

    public Long deleteUser(Long id) throws UserNotFoundException{
        userRepository.deleteById(id);
        return id;
    }
}
