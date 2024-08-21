package com.learn.springboot.todo_managemnt.service;

import com.learn.springboot.todo_managemnt.dto.TodoDTO;
import com.learn.springboot.todo_managemnt.entity.ToDo;
import com.learn.springboot.todo_managemnt.exception.ResourceNotFoundException;
import com.learn.springboot.todo_managemnt.repository.ToDoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceIMPL implements TodoService {

    private ToDoRepository toDoRepository;
    private ModelMapper modelMapper;


    @Override
    public TodoDTO addTodo(TodoDTO todoDTO) {

        ToDo toDo = modelMapper.map(todoDTO, ToDo.class);
        ToDo savedTodo = toDoRepository.save(toDo);

        TodoDTO savedTodoDto = modelMapper.map(savedTodo, TodoDTO.class);
        return savedTodoDto;
    }

    @Override
    public TodoDTO getTodoById(Long id) {

      ToDo receivedTodo = toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found with the id : "+ id));
      return modelMapper.map(receivedTodo, TodoDTO.class);
    }

    @Override
    public List<TodoDTO> getAllTodo() {
      List<ToDo> allTodos = toDoRepository.findAll();
      return allTodos.stream().map((todo) -> modelMapper.map(todo, TodoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TodoDTO updateTodo(TodoDTO todoDTO, Long id) {

     ToDo todo = toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found with the id : "+ id));
     todo.setTitle(todoDTO.getTitle());
     todo.setDescription(todoDTO.getDescription());
     todo.setCompleted(todo.isCompleted());

     ToDo updatedTodo = toDoRepository.save(todo);

     return modelMapper.map(updatedTodo, TodoDTO.class);
    }

    @Override
    public void deleteTodo(Long id) {
        toDoRepository.deleteById(id);

    }

    @Override
    public TodoDTO completeTodo(Long id) {
       ToDo todo = toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found with the id : "+ id));
       todo.setCompleted(Boolean.TRUE);
      ToDo updatedTodo = toDoRepository.save(todo);

       return modelMapper.map(updatedTodo, TodoDTO.class);
    }

    @Override
    public TodoDTO incompleteTodo(Long id) {
        ToDo todo = toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found with the id : "+ id));
        todo.setCompleted(Boolean.FALSE);

        ToDo updatedTodo = toDoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDTO.class);
    }
}
