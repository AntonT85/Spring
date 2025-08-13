package ru.diasoft.example.service;

import java.util.List;

import ru.diasoft.example.domain.Task;

public interface TaskService {

    Task create(Task task);
    Task update(long id, Task task);
    List<Task> getAll();
    Task getById(long id);
    void deleteById(long id);

}
