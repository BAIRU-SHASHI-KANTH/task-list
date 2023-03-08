package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ShowFactory {

    public Show show;
    public final ShowTasks showTasks;
    public final ShowTaskWithDeadlines showTaskWithDeadlines;
    public ShowFactory(Map<String, List<Task>> tasks, PrintWriter out){
        showTasks = new ShowTasks(tasks,out);
        showTaskWithDeadlines = new ShowTaskWithDeadlines(tasks,out);
    }
    public Show get(String commandRest){

        switch (commandRest){
            case "by project":
                show = showTasks;
                break;
            case "by deadline":
                show = showTaskWithDeadlines;
                break;
            default:
                break;
        }

        return this.show;
    }
}
