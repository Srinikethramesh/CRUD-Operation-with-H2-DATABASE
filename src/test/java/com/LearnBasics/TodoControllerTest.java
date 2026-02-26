package com.LearnBasics;

import com.LearnBasics.models.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService service;

    @Test
    void shouldCreateTodo() throws Exception {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setTitle("Test");

        when(service.createTodo(any())).thenReturn(todo);

        mockMvc.perform(post("/api/v1/todo/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                    {
                      "title": "Test"
                    }
                    """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Test"));
    }

    @Test
    void shouldReturnAllTodos() throws Exception {

        Todo todo = new Todo();
        todo.setId(1);
        todo.setTitle("Test");

        when(service.getAllTodo()).thenReturn(List.of(todo));

        mockMvc.perform(get("/api/v1/todo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Test"))
                .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    void shouldReturnTodoById() throws Exception {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setTitle("Test");
        todo.setDescription("Description");
        todo.setCompleted(false);
        todo.setEmail("test@example.com");

        when(service.getTodoById(1)).thenReturn(todo);

        mockMvc.perform(get("/api/v1/todo/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Test"))
                .andExpect(jsonPath("$.description").value("Description"))
                .andExpect(jsonPath("$.completed").value(false))
                .andExpect(jsonPath("$.email").value("test@example.com"));
    }

    @Test
    void shouldReturnNotFound() throws Exception {
        when(service.getTodoById(1)).thenThrow(new RuntimeException());

        mockMvc.perform(get("/api/v1/todo/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldUpdateTodo() throws Exception {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setTitle("Updated");

        when(service.updateTodo(any())).thenReturn(todo);

        mockMvc.perform(put("/api/v1/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                    {
                      "id": 1,
                      "title": "Updated"
                    }
                    """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated"));
    }

    @Test
    void shouldDeleteTodo() throws Exception {
        mockMvc.perform(delete("/api/v1/todo/1"))
                .andExpect(status().isOk());

        verify(service).deleteTodoById(1);
    }


}