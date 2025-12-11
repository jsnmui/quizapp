package com.example.quiz.controller;


import com.example.quiz.domain.User;
import com.example.quiz.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.createNewUser(user);
        return ResponseEntity.ok("User created successfully");
    }

    @DeleteMapping("/user")
    public String deleteUser(@RequestParam("userId") int userId) {
        boolean success = userService.deleteUserById(userId);
        return success ? "User deleted successfully" : "User not found or could not be deleted";
    }

    @PatchMapping("/user/{userId}/status")
    public String updateUserStatus(@PathVariable int userId, @RequestParam boolean activate) {
        boolean success = userService.updateUserStatus(userId, activate);
        return success ? "User status updated successfully" : "User not found or update failed";
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
       List<User> users =  userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserById(@RequestParam int userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
