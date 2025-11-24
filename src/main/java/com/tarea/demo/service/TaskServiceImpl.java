package com.tarea.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.tarea.demo.model.Task;

import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private List<Task> listTask;

    public TaskServiceImpl() {
        if (this.listTask == null) {
            this.listTask = new ArrayList<>();
            this.listTask.add(new Task(1, "Crear modelo UML", true));
            this.listTask.add(new Task(2, "Crear clases JAVA", true));
            this.listTask.add(new Task(3, "Crear plantillas", true));
        }
    }


    @Override
    public List<Task> getAll() {
        return listTask;
    }

    @Override
    public Task save(Task task) {
        int id = (int)listTask.stream().count() + 1 ;
        task.setId(id);
        listTask.add(task);

        return task;
    }

    @Override
    public Task update(int id, Task task) {
        for (int i = 0; i < listTask.size(); i++) {
            if (listTask.get(i).getId() == id) {
                task.setId(id);
                listTask.set(i, task);
                return task;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return listTask.removeIf(t -> t.getId() == id);
    }

}
