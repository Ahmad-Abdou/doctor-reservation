package com.doctor.doctorreservation.controller;

import com.doctor.doctorreservation.entity.User;
import com.doctor.doctorreservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/register")
@CrossOrigin("*")
public class RegisterUser {

    private UserService userService;
    public static User signedUser;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") long id){
        if(id == 0){
            throw new IllegalStateException("Id cannot be 0");
        }
       Optional <User> user1 = userService.findById(id);
       if(user1.isPresent()){
           return ResponseEntity.status(HttpStatus.OK).body( user1.get());
       }

           throw new IllegalStateException("User Not found");

    }

    @PostMapping
    public ResponseEntity<User> register(@RequestBody User user){

         return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.create(user));
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody User user){
      Optional<User> user1 =  userService.findUserByEmail(user.getEmail());

        if(!user1.isPresent()){
            return   ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not found");
        }
            if(!user.getPassword().equals(user1.get().getPassword())){
                return   ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Incorrect password");
            }
            else
                signedUser = user1.get();

        return ResponseEntity.status(HttpStatus.OK).body("Login Successful");

    }
     @PostMapping("/signout")
    public ResponseEntity<String> signOut(){
    signedUser = null;
         SignedUser(null);
        return ResponseEntity.status(HttpStatus.OK).body("Signed out");
    }

     @GetMapping("/myuser")
    public ResponseEntity<String> getSignedUser(){
        if(signedUser == null){
            return ResponseEntity.status(HttpStatus.OK).body(("No user Signed in"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(signedUser.toString());
    }
    public static User SignedUser(User user){
       signedUser = user;
        return signedUser;
    }

}
