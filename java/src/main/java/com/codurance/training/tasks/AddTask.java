package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class AddTask {
    private final TaskList taskList;
    private final Map<String, List<Task>> tasks;
    private final PrintWriter out;

    public AddTask(TaskList taskList, Map<String, List<Task>> tasks, PrintWriter out){
        this.taskList = taskList;
        this.tasks = tasks;
        this.out = out;
    }
    public void add(String project, String description) {
        List<Task> projectTasks = tasks.get(project);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        projectTasks.add(new Task(taskList.nextId(), description, false));
    }
}
