package com.ilmir.taskcontroller.service;

import com.ilmir.taskcontroller.entity.Task;
import com.ilmir.taskcontroller.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task create(Task task){
        if(isNull(task)) {
            return null;
        }
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getByID(long id) {
        if(id == 0) return null;
        return taskRepository.getReferenceById(id);
    }

    @Override
    public Task update(Task task) {
        if(isNull(task)) {
            return null;
        }
        return taskRepository.save(task);
    }

    @Override
    public boolean delete(long id) {
        if(id == 0) return false;
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
