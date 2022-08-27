package Planner.Core.MVP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Planner.Core.Infrastructure.Notebook;
import Planner.Core.Models.Note;

public class Model {

    private Notebook currentBlock;
    private int currentIndex;
    private String path;

    public Model(String path) {
        currentBlock = new Notebook();
        currentIndex = 0;
        this.path = path;
    }

    public Note currentNote() {
        if (currentIndex >= 0) {
            return currentBlock.getTask(currentIndex);
        } else {
            // ???...
            System.out.println("\nЗадач нет!");
            return null;
        }
    }

    public void load() {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String currLine = reader.readLine();
            while (currLine != null) {
                String[] line = currLine.split(",");
                int id = Integer.parseInt(line[0]);
                String date = line[1];
                String time = line[2];
                String deadline = line[3];
                String task = line[4];
                String author = line[5];
                String priority = line[6];
                this.currentBlock.add(new Note(id, date, time, deadline, task, author, priority));
                currLine = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try (FileWriter writer = new FileWriter(path, false)) {
            for (int i = 0; i < currentBlock.count(); i++) {
                Note note = currentBlock.getTask(i);
                writer.append(String.format("%d,%s,%s,%s,%s,%s,%s\n", note.id, note.date, note.time, note.deadline,
                        note.task, note.author, note.priority));
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void clear() {
        // for (var note : currentBlock.getNotes()) {
        // currentBlock.remove(note);
        // }
        currentBlock = new Notebook();
    }

    public Notebook currentBlock() {
        return this.currentBlock;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }

}