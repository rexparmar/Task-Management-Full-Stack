package com.tm.task_management.Controller;

import com.tm.task_management.Model.Task;
import com.tm.task_management.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")  // This will apply to all methods in this controller
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TaskController {

    @Autowired
    private TaskService service;

    // Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    // Create a task
    @PostMapping
    public String createTask(@RequestBody Task task) {
        service.createTask(task);
        return "Task created Successfully!";
    }

    // Get task by ID
    @GetMapping("/{taskId}")
    public Optional<Task> getTaskById(@PathVariable Long taskId) {
        return service.getTaskById(taskId);
    }

    // Update task by ID
    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask) {
        service.updateTask(taskId, updatedTask);
        return updatedTask;
    }

    // Delete task by ID
    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable Long taskId) {
        service.deleteTask(taskId);
        return "Task deleted Successfully!";
    }
}
