package Planner.UI;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import Planner.Core.Infrastructure.Notebook;
import Planner.Core.MVP.View;
import Planner.Core.Models.Note;
import Planner.Config;

public class ConsoleView implements View {
    Scanner in;

    // инициализация сканнера
    public ConsoleView() {
        in = new Scanner(System.in, Charset.forName(Config.charSet));

    }

    // печать текущего блока задач
    public void print(Notebook currentBlock) {

        for (var note : currentBlock.getNotes()) {
            System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\n", note.getId(), note.getDate(), note.getTime(), note.getDeadline(), note.getTask(),
            note.getAuthor(), note.getPriority());
        }

    }

    // установка текущего индекса задачи
    @Override
    public void setCurrIndex(int value) {
        System.out.printf("Текущая задача №: %d\n", value);

    }

    // ввод имени
    @Override
    public String getName() {
        System.out.printf("Имя: ");
        return in.nextLine();
    }

    // вывод имени
    @Override
    public void setName(String value) {
        System.out.printf("Имя: %s\n", value);
    }

    // ввод даты
    @Override
    public String getDate() {
        LocalDate today = LocalDate.now();
        return today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    // вывод даты
    @Override
    public void setDate(String value) {
        System.out.printf("Дата: %s\n", value);
    }

    // ввод задачи
    @Override
    public String getTask() {
        System.out.printf("Задача: ");
        return in.nextLine();
    }

    // вывод задачи
    @Override
    public void setTask(String value) {
        System.out.printf("Задача: %s\n", value);
    }

    // ввод приоритета
    @Override
    public String getPr() {
        String res;
        System.out.printf("Приоритет задачи (1 - низкий, 2 - высокий, любая другая - обычный): ");
        String key = in.next();
        switch (key) {
            case "1":
                res = "LOW";
                break;
            case "2":
                res = "HIGH";
                break;
            default:
                res = "NORMAL";
                break;
        }
        return res;
    }

    // вывод приоритета
    @Override
    public void setPr(String value) {
        System.out.printf("Приоритет задачи: %s\n", value);
    }

    // ввод времени
    @Override
    public String getTime() {
        LocalTime time = LocalTime.now();
        return time.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    // вывод времени
    @Override
    public void setTime(String value) {
        System.out.printf("Время ввода задачи: %s\n", value);
    }

    // вывод дедлайна
    @Override
    public String getDeadline() {
        System.out.printf("Срок исполнения задачи: ");
        return in.nextLine();

    }

    // вывод времени
    @Override
    public void setDeadline(String value) {
        System.out.printf("Срок исполнения задачи: %s\n", value);
    }

    // вывод записи о задаче
    @Override
    public void printNote(Note currentNote) {
        setTask(currentNote.getTask());
        setName(currentNote.getAuthor());
        setDate(currentNote.getDate());
        setDeadline(currentNote.getDeadline());
        setPr(currentNote.getPriority());
    }

}