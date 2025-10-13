package com.example.Tasklist.service;

import com.example.Tasklist.model.Task;
import com.example.Tasklist.model.TaskStatus;
import com.example.Tasklist.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public Task create(Task t) {
        t.setStatus(TaskStatus.PENDING);
        return repo.save(t);
    }

    public List<Task> list(Optional<TaskStatus> status) {
        return status.map(repo::findByStatus).orElseGet(repo::findAll);
    }

    @Transactional
    public Optional<Task> markCompleted(Long id) {
        Optional<Task> maybe = repo.findById(id);
        maybe.ifPresent(t -> t.setStatus(TaskStatus.COMPLETED));
        return maybe;
    }
}
