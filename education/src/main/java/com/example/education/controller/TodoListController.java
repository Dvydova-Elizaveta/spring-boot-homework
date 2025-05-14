package com.example.education.controller;

import com.example.education.dto.TodoListDTO;
import com.example.education.entity.Event;
import com.example.education.entity.TodoList;
import com.example.education.repository.TodoListRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todo")
public class TodoListController {

    private final TodoListRepository todoListRepository;

    public TodoListController(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoListDTO dto) {
        TodoList todoList = new TodoList();
        todoList.setName(dto.getName());

        List<Event> events = dto.getEvents().stream().map(eventName -> {
            Event e = new Event();
            e.setName(eventName);
            e.setTodoList(todoList);
            return e;
        }).collect(Collectors.toList());

        todoList.setEvents(events);
        todoListRepository.save(todoList);
        return ResponseEntity.ok("Создано");
    }

    @GetMapping
    public List<TodoListDTO> getAllTodos() {
        return todoListRepository.findAll().stream().map(todo -> {
            TodoListDTO dto = new TodoListDTO();
            dto.setName(todo.getName());
            dto.setEvents(todo.getEvents().stream().map(Event::getName).toList());
            return dto;
        }).toList();
    }
}
