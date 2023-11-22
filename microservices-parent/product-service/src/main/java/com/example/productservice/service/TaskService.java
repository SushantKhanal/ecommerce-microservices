package com.example.productservice.service;

import com.example.productservice.entity.Task;
import com.example.productservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    //CRUD
    public Task addTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }

    public List<Task> findAllTasks() {
        return repository.findAll();
    }

    public Task getTaskByTaskId(String taskId) {
        return repository.findById(taskId).get();
    }

    public List<Task> getTaskBySeverity(int severity) {
        return repository.findBySeverity(severity);
    }

    public List<Task> getTaskByAssignee(String assignee) {
        return repository.findByAssignee(assignee);
    }

    public Task updateTask(Task taskRequest) {
        //get the existing document from db
        //update
        //save
        Task existingTask = repository.findById(taskRequest.getTaskId()).get();
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());
        existingTask.setSeverity(taskRequest.getSeverity());
        return repository.save(existingTask);
    }

    public String deleteTask(String taskId) {
        repository.deleteById(taskId);
        return "Delete task success!";
    }
}
