package com.example.TaskManager.Service;

import com.example.TaskManager.Entity.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(Task task); // Create a new task
    List<Task> getAllTasks(); // Retrieve all tasks
    Task getTaskById(Long id); // Retrieve a task by ID
    Task updateTask(Long id, Task task); // Update a task
    void deleteTaskById(Long id); // Delete a task by ID



}
