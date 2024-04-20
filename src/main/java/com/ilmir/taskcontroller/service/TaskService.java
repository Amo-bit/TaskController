package com.ilmir.taskcontroller.service;

import com.ilmir.taskcontroller.entity.Task;

import java.util.List;

public interface TaskService {

    /**
     * Создает новую задачу
     * @param task - задача для создания
     */
    Task create(Task task);

    /**
     * Возвращает список всех имеющихся задач
     * @return список задач
     */
    List<Task> getAll();

    /**
     * Возвращает задачу по id
     * @param id - ИД задачи
     * @return - объект задачи с заданным id
     */
    Task getByID(long id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param task- клиент в соответсвии с которым нужно обновить данные
     * @return - true если данные были обновлены, иначе false
     */
    Task update(Task task);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(long id);
}
