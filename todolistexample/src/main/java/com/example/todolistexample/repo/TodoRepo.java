package com.example.todolistexample.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.todolistexample.model.TodoItem;

public interface TodoRepo extends JpaRepository<TodoItem, Long> {

}
