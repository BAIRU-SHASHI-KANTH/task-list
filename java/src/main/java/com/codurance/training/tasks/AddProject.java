package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddProject implements AddCommand{
    private final Map<String, List<Task>> tasks;
    public AddProject(Map<String, List<Task>> tasks){
        this.tasks = tasks;
    }
    public void add(String name) {
        tasks.put(name, new ArrayList<Task>());
    }
}
