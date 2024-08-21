package com.learn.springboot.todo_managemnt.repository;

import com.learn.springboot.todo_managemnt.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}
