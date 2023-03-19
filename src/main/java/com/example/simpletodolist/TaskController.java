package com.example.simpletodolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @GetMapping("/all")
    public Iterable<Task> getAll() {
        Iterable<Task> taskList = repository.findAllByOrderByPriority();
        return repository.findAllByOrderByPriority();
    }

    @PostMapping("/add")
    public RequestResult addTask(
            @RequestParam String priority,
            @RequestParam String name,
            @RequestParam String description
    ) {
        Task item = new Task(priority, name, description);
        Task saved = repository.save(item);
        return new RequestResult("added", saved);
    }

    @PostMapping("/update")
    public RequestResult updateItem(
            @RequestParam Long id,
            @RequestParam String priority,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam boolean isComplete
    ) {
        Task item = new Task(id, priority, name, description);
        item.setCompleted(isComplete);
        Task saved = repository.save(item);
        return new RequestResult("updated", saved);
    }

    class RequestResult {

        private String status;
        private Task item;

        public RequestResult() {
            status = "";
            item = null;
        }

        public RequestResult(String status, Task item) {
            this.status = status;
            this.item = item;
        }

        public String getStatus() {
            return status;
        }

        public Task getItem() {
            return item;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setItem(Task item) {
            this.item = item;
        }

    }

}
