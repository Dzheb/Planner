package Planner.Core.MVP;

import Planner.Core.Infrastructure.Notebook;
import Planner.Core.Models.Note;

public interface View {

    //установка текущего номера записи
    void setCurrIndex(int value);
    //печать всех записей
    void print(Notebook currentBlock);

    void printNote(Note currentNote);
    // ввод имени, даты,  задачи, приоритета, времени, дедлайна

    String getName();
    void setName(String value);
    // 
    String getDate();
    void setDate(String value);
    // 
    String getTask();
    void setTask(String value);
    // 
    String getPr();
    void setPr(String priority);
    // 
    String getTime();
    void setTime(String value);
    // 
    String getDeadline();
    void setDeadline(String value);
    // 

}