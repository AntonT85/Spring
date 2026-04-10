package ru.diasoft.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diasoft.example.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
