package com.example.simpletodolist;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String priority;
    private String name;
    private String description;
    private boolean completed;

    public Task() {}

    public Task(String priority, String name, String description) {
        this.priority = priority;
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    public Task(Long id, String priority, String name, String description) {
        this.id = id;
        this.priority = priority;
        this.name = name;
        this.description = description;
        this.completed = false;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean isComplete) {
        this.completed = isComplete;
    }

    @Override
    public String toString() {
        return String.format("Task[id=%d, priority=%s, name=%s, description=%s, completed=%b]",
                id, priority, name, description, completed);
    }
}
