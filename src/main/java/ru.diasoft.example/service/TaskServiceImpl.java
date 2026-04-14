package ru.diasoft.example.service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.diasoft.example.dao.TaskRepository;
import ru.diasoft.example.domain.Task;
import ru.diasoft.example.exception.NoSuchTaskException;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Override
    @Transactional
    public Task create(Task task) {
        return repository.save(task);
    }

    @Override
    @Transactional
    public Task update(long id, Task task) {
        Task updateTask = repository.findById(id)
                .orElseThrow(() -> new NoSuchTaskException("Task with id = " + id + " not found"));

        updateTask.setName(task.getName());

        return repository.save(updateTask);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Task getById(long id) {
        Optional<Task> task = repository.findById(id);
        if (task.isEmpty()) {
            throw new NoSuchTaskException("Task with id = " + id + " not found");
        }
        return task.get();
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new NoSuchTaskException("Task with id = " + id + " not found"));

        repository.delete(task);

    }
    @Override
    public List<Task> findByName(String name) {
        return repository.findByName(name);
    }
}
