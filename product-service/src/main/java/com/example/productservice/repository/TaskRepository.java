package com.example.productservice.repository;

import com.example.productservice.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findBySeverity(int severity);

    List<Task> findByAssignee(String assignee);
}
