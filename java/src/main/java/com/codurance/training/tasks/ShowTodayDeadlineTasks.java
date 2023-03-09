package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ShowTodayDeadlineTasks implements Show{
    private final Map<String, List<Task>> tasks;
    private final PrintWriter out;
    public ShowTodayDeadlineTasks(Map<String, List<Task>> tasks, PrintWriter out){
        this.tasks = tasks;
        this.out = out;
    }
    public void show() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateToday = dateFormat.format(date);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                String deadline = task.getDeadLine();

                if(deadline.equals(dateToday)) {
                    out.printf("    [%c] %d: %s%s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription(), (deadline != null ? "{" + deadline + "}" : ""));
                }
            }
            out.println();
        }
    }
}
