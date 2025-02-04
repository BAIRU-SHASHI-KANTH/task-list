package com.codurance.training.tasks;
public final class Task {
    private final long id;
    private final String description;
    private boolean done;

    private String date;

    public Task(long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setDeadLine(String date){
        this.date = date;
    }
    public String getDeadLine(){
        return date;
    }

}
