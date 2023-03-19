package com.example.simpletodolist;

import java.util.ArrayList;

public class TaskViewModel {

    private ArrayList<Task> taskList = new ArrayList<>();

    public TaskViewModel() {}

    public TaskViewModel(Iterable<Task> items) {
        for (Task item : items) {
            taskList.add(item);
        }
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

}
