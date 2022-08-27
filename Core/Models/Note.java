package Planner.Core.Models;

public class Note implements Comparable<Note> {
    public int id;
    public String date;
    public String time;
    public String deadline;
    public String task;
    public String author;
    public String priority;

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

}