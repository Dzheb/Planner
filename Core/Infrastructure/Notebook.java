package Planner.Core.Infrastructure;

import java.util.ArrayList;
import java.util.List;

import Planner.Core.Models.Note;

public class Notebook {

    private List<Note> tasks;

    public Notebook() {
        tasks = new ArrayList<>();
    }

    // добавление задачи
    public boolean add(Note note) {
        // boolean flag = false;
        if (!tasks.contains(note)) {
            tasks.add(note);
            return true;
        } else {

            return false;
        }
    }

    // чтение задачи
    public Note getTask(int index) {
        return contains(index) ? tasks.get(index) : null;
    }

    // удаление задачи
    public boolean remove(int index) {
        // boolean flag = false;
        if (index != -1) {
            tasks.remove(tasks.get(index));
            return true;
        } else {

            return false;
        }
    }

    private boolean contains(int index) {
        return tasks != null
                && tasks.size() > index;
    }

    public List<Note> getNotes() {
        return tasks;
    }

    public int count() {
        return tasks.size();
    }
}