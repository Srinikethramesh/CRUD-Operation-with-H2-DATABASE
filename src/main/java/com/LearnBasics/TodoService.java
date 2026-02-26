package com.LearnBasics;
import com.LearnBasics.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repo;

    //TO CREATE
    public Todo createTodo(Todo todo)
    {
        return repo.save(todo);
    }

    //TO READY ONLY ONE ID
    public Todo getTodoById(Integer id)
    {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
    }

    //TO READ ALL ID
    public List<Todo> getAllTodo()
    {
        return repo.findAll();
    }

    //To UPDATE
    public Todo updateTodo(Todo todo)
    {
        return repo.save(todo);
    }

    //TO DELETEBYID
    public void deleteTodoById(int id)
    {
        repo.delete(getTodoById(id));
    }

    //TO DELETE BYTODO
    public void deleteTodo(Todo todo)
    {
        repo.delete(todo);
    }


}
