package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExecuteCommands {
    private final ShowFactory showFactory;
    private final UpdateTask updateTask;
    private final Add add;
    private final TaskDeadline taskDeadline;
    private final ShowTodayDeadlineTasks showTodayDeadlineTasks;
    private final DeleteTask deleteTask;
    private final Help help;
    private final Error error;
    private final TaskList taskList;
    private final Map<String, List<Task>> tasks;
    private final PrintWriter out;
    public ExecuteCommands(TaskList taskList, Map<String, List<Task>> tasks, PrintWriter out){

        this.taskList=taskList;
        this.tasks = tasks;
        this.out = out;
        this.showFactory = new ShowFactory(tasks,out);
        this.updateTask = new UpdateTask(tasks,out);
        this.add = new Add(taskList, tasks, out);
        this.taskDeadline = new TaskDeadline(tasks, out);
        this.showTodayDeadlineTasks = new ShowTodayDeadlineTasks(tasks,out);
        this.deleteTask = new DeleteTask(tasks, out);
        this.help = new Help(out);
        this.error = new Error(out);
    }

    public void execute(String commandLine) {

        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];

        switch (command) {
            case "view":
                showFactory.get(commandRest[1]).show();
                break;
            case "add":
                add.add(commandRest[1]);
                break;
            case "check":
                updateTask.setDone(commandRest[1],true);
                break;
            case "uncheck":
                updateTask.setDone(commandRest[1],false);
                break;
            case "deadline":
                taskDeadline.setDeadline(commandRest[1]);
                break;
            case "today":
                showTodayDeadlineTasks.show();
                break;
            case "delete":
                deleteTask.delete(commandRest[1]);
                break;
            case "help":
                help.help();
                break;
            default:
                error.error(command);
                break;
        }
    }

}
