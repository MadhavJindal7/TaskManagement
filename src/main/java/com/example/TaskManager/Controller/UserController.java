package com.example.TaskManager.Controller;

import com.example.TaskManager.Entity.User;
import com.example.TaskManager.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping
    public List<User> getAll() {
        return userService.getAllUser();
    }
    @PostMapping
    public User createUser(@RequestBody @Valid User user) {
        return userService.createUser(user);
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody @Valid User user) {
        return userService.updateUser(id, user);
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}

