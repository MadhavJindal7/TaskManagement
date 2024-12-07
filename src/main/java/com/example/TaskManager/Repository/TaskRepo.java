package com.example.TaskManager.Repository;
import com.example.TaskManager.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Long>{

}
