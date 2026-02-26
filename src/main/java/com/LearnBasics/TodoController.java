package com.LearnBasics;

import com.LearnBasics.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    @Autowired
    private TodoService service;

    //Create Todo
    @PostMapping("/create")
    ResponseEntity<Todo> createUser(@RequestBody Todo todo) {
       return new ResponseEntity<>(service.createTodo(todo), HttpStatus.CREATED);
    }


    // GetOneTodo
    @GetMapping("{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable int id)
    {
        try {
            return new ResponseEntity<>(service.getTodoById(id), HttpStatus.OK);
        }
        catch(RuntimeException exception)
        {
            return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
        }
    }

    //GetAllTodo
    @GetMapping
    public List<Todo> getAllTodo() {
        return service.getAllTodo();
    }

    //UpdateTodo
    @PutMapping("")
    ResponseEntity<Todo> updateTodo(@RequestBody Todo todo)
    {
       return new ResponseEntity<>(service.updateTodo(todo) , HttpStatus.OK);
    }

    //DeleteTodo
    @DeleteMapping("/{id}")
    void deleteTodoById(@PathVariable int id)
    {
        service.deleteTodoById(id);
    }

}
