package com.doctor.doctorreservation.service;



import com.doctor.doctorreservation.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(User user);

   Optional<User>  findById(long id);

    List<User> findAllUsers();

    Optional <User> findUserByEmail(String email);
}
