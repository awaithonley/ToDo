package com.honley.ToDo.model;

import com.honley.ToDo.entity.TodoEntity;

public class Todo {
    private Long id;
    private String title;
    private Boolean completed;
    private String description;

    public static Todo toModel(TodoEntity todoEntity){
        Todo model = new Todo();
        model.setId(todoEntity.getId());
        model.setCompleted(todoEntity.getCompleted());
        model.setTitle(todoEntity.getTitle());
        model.setDescription(todoEntity.getDescription());

        return model;
    }

    public Todo(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
