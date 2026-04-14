package ru.diasoft.example.dao;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.diasoft.example.domain.Task;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@DisplayName("Класс TaskRepository должен")
class TaskRepositoryTest {

    @Autowired
    private TaskRepository repository;

    @Test
    @DisplayName("Искать задачу по имени")
    void findByName() {
        Task task = new Task(1, "Task1");
        repository.save(task);

        List<Task> getTask = repository.findByName("Task1");

        assertThat(task).isEqualTo(getTask.get(0));
    }

}