package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class DeleteTask implements DeleteCommand{

    private final Map<String, List<Task>> tasks;
    private final PrintWriter out;

    public DeleteTask(Map<String, List<Task>> tasks, PrintWriter out){
        this.tasks = tasks;
        this.out = out;
    }
    public void delete(String idString) {
        long id = Long.parseLong(idString);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    project.getValue().remove(task);
                    out.printf("deleted a task with an ID of %d.", id);
                    out.println();
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
