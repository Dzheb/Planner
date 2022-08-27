package Planner.Core.Models;

public class Note implements Comparable<Note> {
    private int id;
    private String date;
    private String time;
    private String deadline;
    private String task;
    private String author;
    private String priority;

    public Note(Integer id, String date, String time, String deadline, String task, String author, String priority) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.deadline = deadline;
        this.task = task;
        this.author = author;
        this.priority = priority;
    }

    @Override
    public int compareTo(Note o) {

        if (this.deadline == o.deadline && this.priority == o.priority)
            return 1;
        else
            return 0;
    }

    @Override
    public boolean equals(Object obj) {
        Note nt = (Note) obj;
        return this.id == nt.id
                && this.task == nt.task;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getTask() {
        return task;
    }

    public String getAuthor() {
        return author;
    }

    public String getPriority() {
        return priority;
    }

}