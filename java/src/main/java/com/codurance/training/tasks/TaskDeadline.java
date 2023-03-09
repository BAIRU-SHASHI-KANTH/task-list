package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class TaskDeadline implements Deadline {
    private final Map<String, List<Task>> tasks;
    private final PrintWriter out;
    public TaskDeadline(Map<String, List<Task>> tasks, PrintWriter out){
        this.tasks = tasks;
        this.out = out;
    }
    public void setDeadline(String commandLine) {

        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        int id = Integer.parseInt(subcommand);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDeadLine(subcommandRest[1]);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
