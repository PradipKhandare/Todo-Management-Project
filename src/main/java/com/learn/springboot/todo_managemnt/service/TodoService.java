package com.learn.springboot.todo_managemnt.service;

import com.learn.springboot.todo_managemnt.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    TodoDTO addTodo(TodoDTO todoDTO);

    TodoDTO getTodoById(Long id);

    List<TodoDTO> getAllTodo();

    TodoDTO updateTodo(TodoDTO todoDTO, Long id);

    void deleteTodo(Long id);

    TodoDTO completeTodo(Long id);

    TodoDTO incompleteTodo(Long id);
}
