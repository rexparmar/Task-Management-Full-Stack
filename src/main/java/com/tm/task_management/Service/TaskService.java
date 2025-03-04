package com.tm.task_management.Service;


import com.tm.task_management.Model.Task;
import com.tm.task_management.Repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepo repo;

    public List<Task> getAllTasks(){
        return repo.findAll();
    }

    public Optional<Task> getTaskById(Long taskId){
        return repo.findById(taskId);
    }

    public void createTask(Task task){
        repo.save(task);
    }

    public Task updateTask(Long id, Task updatedTask){
        if(repo.existsById(id)){
           updatedTask.setId(id);
           return repo.save(updatedTask);
        }
        return null;
    }

    public void deleteTask(Long taskId){
        repo.deleteById(taskId);
    }
}
