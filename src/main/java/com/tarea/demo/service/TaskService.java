package com.tarea.demo.service;

import java.util.List;

import com.tarea.demo.model.Task;

public interface TaskService {
    List<Task> getAll();
    Task save(Task task);
    Task update(int id, Task task);
    boolean delete(int id);
}
