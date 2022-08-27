package Planner.Core.MVP;

import Planner.Core.Models.Note;

public class Presenter {

    private Model model;
    private View view;

    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new Model(pathDb);
    }
    // загрузка из файла
    public void loadFromFile() {
        model.clear(); // очищаем текущую книгу, иначе она дополняется точно такими же записями
        model.load();
        if (model.currentBlock().count() > 0) {
            model.setCurrentIndex(0);
            Note note = model.currentNote();
            view.print(model.currentBlock());
            view.printNote(note);

        }
    }

    // добавить механизм добавления записей и проверку корректности...
    public void add() {
        model.currentBlock().add(new Note(model.currentBlock().count() + 1, view.getDate(), view.getTime(),view.getDeadline(), view.getTask(), view.getName(), view.getPr()));
        view.print(model.currentBlock());

    }
    // удаление задачи
    public void remove() {
        if (model.currentBlock().count() < 1) {
            model.setCurrentIndex(-1);
            view.print(model.currentBlock());
            view.setCurrIndex(model.getCurrentIndex());
        } else {
            model.currentBlock().remove(model.getCurrentIndex());
            model.setCurrentIndex(model.getCurrentIndex() - 1);
            if (model.getCurrentIndex() < 0)
                model.setCurrentIndex(0);
            view.print(model.currentBlock());

        }
    }
    // сохранение в файл
    public void saveToFile() {
        model.save();
    }
    // вывод последующей записи
    public void next() {
        if (model.currentBlock().count() > 0) {
            if (model.getCurrentIndex() + 1 < model.currentBlock().count()) {
                model.setCurrentIndex(model.getCurrentIndex() + 1);
                view.print(model.currentBlock());
            } else if (model.getCurrentIndex() < model.currentBlock().count()) {
                System.out.println("\nПоследняя задача планировщика");
            }
            Note note = model.currentNote();
            view.printNote(note);

        }
    }
    // вывод ппедыдущей записи
    public void prev() {
        if (model.currentBlock().count() > 0) {
            if (model.getCurrentIndex() - 1 > -1) {
                model.setCurrentIndex(model.getCurrentIndex() - 1);
                view.print(model.currentBlock());
            } else if (model.getCurrentIndex() == 0) {
                System.out.println("\nПервая задача планировщика");
            }
            Note note = model.currentNote();
            view.printNote(note);

        }
    }
}