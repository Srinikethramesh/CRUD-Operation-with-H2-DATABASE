package com.LearnBasics.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {

    @Test
    void shouldSetAndGetId() {
        Todo todo = new Todo();
        todo.setId(1);
        assertEquals(1, todo.getId());
    }

    @Test
    void shouldSetAndGetTitle() {
        Todo todo = new Todo();
        todo.setTitle("Test Title");
        assertEquals("Test Title", todo.getTitle());
    }

    @Test
    void shouldSetAndGetDescription() {
        Todo todo = new Todo();
        todo.setDescription("Test Description");
        assertEquals("Test Description", todo.getDescription());
    }

    @Test
    void shouldSetAndGetCompleted() {
        Todo todo = new Todo();
        todo.setCompleted(true);
        assertTrue(todo.getCompleted());
        
        todo.setCompleted(false);
        assertFalse(todo.getCompleted());
    }

    @Test
    void shouldSetAndGetEmail() {
        Todo todo = new Todo();
        todo.setEmail("test@example.com");
        assertEquals("test@example.com", todo.getEmail());
    }

    @Test
    void shouldCreateTodoWithAllFields() {
        Todo todo = new Todo();
        todo.setId(1);
        todo.setTitle("Test");
        todo.setDescription("Description");
        todo.setCompleted(true);
        todo.setEmail("test@example.com");

        assertEquals(1, todo.getId());
        assertEquals("Test", todo.getTitle());
        assertEquals("Description", todo.getDescription());
        assertTrue(todo.getCompleted());
        assertEquals("test@example.com", todo.getEmail());
    }
}
