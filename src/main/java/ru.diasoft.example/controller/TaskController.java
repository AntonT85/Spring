package ru.diasoft.example.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.diasoft.example.domain.Task;
import ru.diasoft.example.service.TaskService;

@RestController
@RequiredArgsConstructor
@RequestMapping("edu/v1")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/task")
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @PutMapping("/task/{id}")
    public Task update(@PathVariable long id, @RequestBody Task task) {
        return taskService.update(id, task);
    }

    @GetMapping("/task")
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/task/{id}")
    public Task getById(@PathVariable long id) {
        return taskService.getById(id);
    }

    @DeleteMapping("/task/{id}")
    public void deleteById(@PathVariable long id) {
        taskService.deleteById(id);
    }
}
