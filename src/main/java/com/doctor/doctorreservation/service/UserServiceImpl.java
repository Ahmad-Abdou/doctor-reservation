package com.doctor.doctorreservation.service;

import com.doctor.doctorreservation.entity.User;
import com.doctor.doctorreservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        System.out.println(userRepository.findByEmail(user.getEmail()));
       if(userRepository.findByEmail(user.getEmail()).equals(Optional.empty()) ){
           return userRepository.save(user);
       }

        throw new IllegalStateException("User already exist");
    }

    @Override
    public Optional<User> findById(long id) {
        Optional <User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user;
        }
      throw new IllegalStateException("User not found");
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            return user;
        }
        throw new IllegalStateException("User not found");
    }
}
