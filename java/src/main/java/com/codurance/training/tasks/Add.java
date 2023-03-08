package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Add implements AddCommand{

    private final AddProject addProject;
    private final AddTask addTask;
    private final TaskList taskList;
    public Add(TaskList taskList, Map<String, List<Task>> tasks, PrintWriter out){
        this.taskList = taskList;
        this.addProject = new AddProject(tasks);
        this.addTask = new AddTask(taskList,tasks,out);
    }
    public void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject.add(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask.add(projectTask[0], projectTask[1]);
        }
    }
}
