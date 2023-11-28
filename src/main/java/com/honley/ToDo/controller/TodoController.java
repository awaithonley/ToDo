package com.honley.ToDo.controller;

import com.honley.ToDo.entity.TodoEntity;
import com.honley.ToDo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId){
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Пройзошла ошибка !");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id){
        try {
            return ResponseEntity.ok(todoService.complete(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Пройзошла ошибка !");
        }
    }
}
