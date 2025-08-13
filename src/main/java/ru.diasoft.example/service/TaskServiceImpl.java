package ru.diasoft.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import ru.diasoft.example.domain.Task;
import ru.diasoft.example.exception.NoSuchTaskException;

@Service
public class TaskServiceImpl implements TaskService {

    private final List<Task> taskList;
    private final AtomicLong atomicLong;

    public TaskServiceImpl() {
        this.taskList = new ArrayList<>();
        this.atomicLong = new AtomicLong();
    }

    @Override
    public Task create(Task task) {
        task.setId(atomicLong.incrementAndGet());
        taskList.add(task);
        return task;
    }
    @Override
    public Task update(long id, Task task) {
        taskList.removeIf(p -> p.getId() == id);
        task.setId(id);
        taskList.add(task);
        return task;
    }
    @Override
    public List<Task> getAll() {
        return taskList;
    }
    @Override
    public Task getById(long id) {
        return taskList.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchTaskException("Task with id = " + id + " not found"));
    }
    @Override
    public void deleteById(long id) {
        taskList.removeIf(p -> p.getId() == id);
    }
}
