package ru.diasoft.example.service;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.diasoft.example.dao.TaskRepository;
import ru.diasoft.example.domain.Task;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Класс TaskServiceImplTest должен")
class TaskServiceImplTest {

    @Mock
    private TaskRepository repository;

    private TaskService taskService;

    @BeforeEach
    private void init() {
        taskService = new TaskServiceImpl(repository);
    }

    @Test
    @DisplayName("Создавать задачу")
    void create() {
        Task task = new Task(1, "Task1");
        when(repository.save(task)).thenReturn(task);

        Task createdTask = taskService.create(task);

        assertThat(task).isEqualTo(createdTask);
    }

    @Test
    @DisplayName("Возвращать задачу по ID")
    void getById() {
        Task task = new Task(1, "Task1");
        when(repository.findById(1L)).thenReturn(Optional.of(task));

        Task getTask = taskService.getById(1L);

        assertThat(task).isEqualTo(getTask);
    }
}