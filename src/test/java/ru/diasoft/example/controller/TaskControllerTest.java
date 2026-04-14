package ru.diasoft.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.diasoft.example.domain.Task;
import ru.diasoft.example.service.TaskService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TaskController.class)
@DisplayName("Класс TaskController должен")
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TaskService taskService;

    @Test
    @DisplayName("создать задачу")
    void create()
            throws Exception
    {
        Task task = new Task(1, "Task1");
        given(taskService.create(task)).willReturn(task);

        mockMvc.perform(post("/edu/v1/task").contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsBytes(task)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(task)));
    }

    @Test
    @DisplayName("вернуть задачу по ID")
    void getById()
            throws Exception
    {
        Task task = new Task(1, "Task1");
        given(taskService.getById(1)).willReturn(task);

        mockMvc.perform(get("/edu/v1/task/" + 1))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(task)));
    }
}