package com.learn.springboot.todo_managemnt.controller;

import com.learn.springboot.todo_managemnt.dto.TodoDTO;
import com.learn.springboot.todo_managemnt.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {
    TodoService todoService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<TodoDTO> addTodo(@RequestBody TodoDTO todoDTO){
       TodoDTO savedTodo = todoService.addTodo(todoDTO);
       return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/get/{id}")
    public ResponseEntity<TodoDTO> getTodoById(@PathVariable Long id){
        TodoDTO savedTodo = todoService.getTodoById(id);
        return new ResponseEntity<>(savedTodo, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/get/all")
    public ResponseEntity<List<TodoDTO>> getAllTodos(){
      List<TodoDTO> allTodos = todoService.getAllTodo();
      return new ResponseEntity<>(allTodos, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<TodoDTO> updateTodo(@RequestBody TodoDTO todoDTO,@PathVariable Long id){
       TodoDTO updatedTodo = todoService.updateTodo(todoDTO, id);
       return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDTO> complete(@PathVariable Long id){
     TodoDTO updatedTodo = todoService.completeTodo(id);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("{id}/incomplete")
    public ResponseEntity<TodoDTO> inComplete(@PathVariable Long id){
        TodoDTO updatedTodo = todoService.incompleteTodo(id);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

}
