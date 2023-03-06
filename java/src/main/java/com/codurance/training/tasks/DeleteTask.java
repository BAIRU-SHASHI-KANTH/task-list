package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class DeleteTask {
    public void delete(String idString, PrintWriter out, Map<String, List<Task>> tasks) {
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
