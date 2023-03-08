package com.codurance.training.tasks;


import java.io.PrintWriter;
        import java.util.List;
        import java.util.Map;

public class ShowTaskWithDeadlines implements Show{
    private final Map<String, List<Task>> tasks;
    private final PrintWriter out;
    public ShowTaskWithDeadlines(Map<String, List<Task>> tasks, PrintWriter out){
        this.tasks = tasks;
        this.out = out;
    }
    @Override
    public void show() {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                String deadline = task.getDeadLine();
                out.printf("    [%c] %d: %s - { deadline : %s }%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription(),deadline);
            }
            out.println();
        }
    }
}
