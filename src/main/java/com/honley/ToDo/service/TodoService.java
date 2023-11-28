package com.honley.ToDo.service;

import com.honley.ToDo.entity.TodoEntity;
import com.honley.ToDo.entity.UserEntity;
import com.honley.ToDo.model.Todo;
import com.honley.ToDo.repository.TodoRepository;
import com.honley.ToDo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepository.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepository.save(todo));
    }

    public Todo complete(Long id){
        TodoEntity todo = todoRepository.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepository.save(todo));
    }
}
