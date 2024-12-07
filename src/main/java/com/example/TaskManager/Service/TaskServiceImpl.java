package com.example.TaskManager.Service;

import com.example.TaskManager.Entity.Task;
import com.example.TaskManager.Entity.User;
import com.example.TaskManager.Repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class TaskServiceImpl implements TaskService  {
    private final UserService userService;
    private final TaskRepo taskRepository;


    @Autowired
    public TaskServiceImpl(TaskRepo theTaskRepository,UserService userService) {
        taskRepository = theTaskRepository;

        this.userService=userService;
    }
    @Override
    public Task createTask(Task task) {
        User result=userService.getUserById(task.getUser().getId());
        if(!result.getIsActive()) throw new RuntimeException("user is inactive");
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new RuntimeException("Task not found with ID: " + id);
        }
        return optionalTask.get();
    }



    @Override
    public Task updateTask(Long id, Task taskDetails) {
        Task task = getTaskById(id);
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        return taskRepository.save(task);
    }

    @Override
    public void deleteTaskById(Long id) {

        Task task = getTaskById(id);
        taskRepository.delete(task);
    }

}
