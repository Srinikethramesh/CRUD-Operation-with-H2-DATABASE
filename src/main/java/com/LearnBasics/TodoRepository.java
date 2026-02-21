package com.LearnBasics;

import com.LearnBasics.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

//CRUD OPERATIONS - CREATE,READ,UPDATE,DELETE
public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
