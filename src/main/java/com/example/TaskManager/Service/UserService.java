package com.example.TaskManager.Service;

import com.example.TaskManager.Entity.Task;
import com.example.TaskManager.Entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user); // Create a new task
    List<User> getAllUser(); // Retrieve all tasks
    User getUserById(Long id); // Retrieve a task by ID
    User updateUser(Long id,User user); // Update a task
    void deleteUserById(Long id); // Delete
}
