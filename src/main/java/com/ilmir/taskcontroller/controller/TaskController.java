package com.ilmir.taskcontroller.controller;

import com.ilmir.taskcontroller.entity.Task;
import com.ilmir.taskcontroller.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Task>> getAll(){
        val taskList = taskService.getAll();
        return taskList.isEmpty()
                ? ResponseEntity.status(NOT_FOUND).build()
                : ResponseEntity.ok().body(taskList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> getByID(@PathVariable(name = "id") long id){
        val task = taskService.getByID(id);
        return task != null
                ? new ResponseEntity<>(task, OK)
                : new ResponseEntity<>(NOT_FOUND);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> create(@RequestBody Task task){
        val result = taskService.create(task);
        return result != null
                ? new ResponseEntity<>(OK)
                : new ResponseEntity<>(BAD_REQUEST);
    }

    @PutMapping(value = "/")
    public ResponseEntity<?> update(@RequestBody Task task){
        val result = taskService.update(task);
        return result != null
                ? new ResponseEntity<>(OK)
                : new ResponseEntity<>(NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id){
        val result = taskService.delete(id);
        return result
                ? new ResponseEntity<>(OK)
                : new ResponseEntity<>(NOT_FOUND);
    }
}
