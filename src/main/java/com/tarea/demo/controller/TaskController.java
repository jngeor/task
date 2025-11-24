package com.tarea.demo.controller;

import com.tarea.demo.model.Task;
import com.tarea.demo.service.TaskService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("tareas", taskService.getAll());
        return "index";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Task tarea) {
        taskService.save(tarea);
        return "redirect:/tareas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        taskService.delete(id);
        return "redirect:/tareas";
    }

}
