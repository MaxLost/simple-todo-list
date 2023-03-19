package com.example.simpletodolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
public class AppController {

    @Autowired
    private TaskRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Task> taskList = repository.findAllByOrderByPriority();
        model.addAttribute("items", new TaskViewModel(taskList));
        model.addAttribute("new_item", new Task());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Task requestItem) {
        Task item = new Task();
        item.setPriority(requestItem.getPriority());
        item.setName(requestItem.getName());
        item.setDescription(requestItem.getDescription());
        repository.save(item);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute TaskViewModel requestItems) {
        for (Task requestedItem : requestItems.getTaskList()) {

            Task item = new Task();
            item.setId(requestedItem.getId());
            item.setPriority(requestedItem.getPriority());
            item.setName(requestedItem.getName());
            item.setDescription(requestedItem.getDescription());
            item.setCompleted(requestedItem.isCompleted());

            if (!requestedItem.isCompleted()) {
                repository.save(item);
            } else {
                repository.delete(item);
            }
        }
        return "redirect:/";
    }

}
