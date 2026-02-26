package com.LearnBasics;

import com.LearnBasics.models.Todo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository repo;

    @InjectMocks
    private TodoService service;

    @Test
    void shouldCreateTodo() {
        Todo todo = new Todo();
        todo.setTitle("Test");

        when(repo.save(any())).thenReturn(todo);

        Todo saved = service.createTodo(todo);

        assertNotNull(saved);
        verify(repo).save(todo);
    }

    @Test
    void shouldThrowWhenIdNotFound() {
        when(repo.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,
                () -> service.getTodoById(1));
    }

    @Test
    void shouldReturnAllTodos() {
        when(repo.findAll()).thenReturn(List.of(new Todo()));

        List<Todo> todos = service.getAllTodo();

        assertFalse(todos.isEmpty());
        verify(repo).findAll();
    }

    @Test
    void shouldUpdateTodo() {
        Todo todo = new Todo();
        todo.setId(1);

        when(repo.save(todo)).thenReturn(todo);

        Todo updated = service.updateTodo(todo);

        assertNotNull(updated);
        verify(repo).save(todo);
    }

    @Test
    void shouldDeleteById() {
        Todo todo = new Todo();
        todo.setId(1);

        when(repo.findById(1)).thenReturn(Optional.of(todo));

        service.deleteTodoById(1);

        verify(repo).delete(todo);
    }

    @Test
    void shouldGetTodoById() {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setTitle("Test");

        when(repo.findById(1)).thenReturn(Optional.of(todo));

        Todo result = service.getTodoById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Test", result.getTitle());
        verify(repo).findById(1);
    }

    @Test
    void shouldDeleteTodo() {
        Todo todo = new Todo();
        todo.setId(1);

        service.deleteTodo(todo);

        verify(repo).delete(todo);
    }
}