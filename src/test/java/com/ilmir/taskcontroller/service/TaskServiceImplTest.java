package com.ilmir.taskcontroller.service;

import com.ilmir.taskcontroller.entity.Task;
import com.ilmir.taskcontroller.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskServiceImpl taskService;

    @Test
    void create() {
        Task task = new Task();
        Long id = 100L;
        task.setId(id);

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        var actual = taskService.create(new Task());

        assertThat(actual, notNullValue());
        assertThat(actual.getId(), equalTo(id));
    }

    @Test
    void createWhenTaskNull() {
        when(taskRepository.save(null)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> taskService.create(null));
    }

    @Test
    void getAll() {
        List<Task> listTask = new ArrayList<>();
        Task task = new Task();
        Long id = 100L;
        task.setId(id);
        listTask.add(task);

        when(taskRepository.findAll()).thenReturn(listTask);

        var actual = taskService.getAll();

        assertThat(actual, notNullValue());
        assertThat(actual, equalTo(listTask));
    }

    @Test
    void getByID() {
        Task task = new Task();
        Long id = 100L;
        task.setId(id);

        when(taskRepository.getReferenceById(any(Long.class))).thenReturn(task);

        var actual = taskService.getByID(id);

        assertThat(actual, notNullValue());
        assertThat(actual.getId(), equalTo(id));
    }

    @Test
    void getByIDNull() {
        when(taskRepository.getReferenceById(0L)).thenThrow(EntityNotFoundException.class);
        assertThrows(EntityNotFoundException.class, () -> taskService.getByID(0L));
    }

    @Test
    void update() {
        Task task = new Task();
        Long id = 100L;
        task.setId(id);

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        var actual = taskService.create(new Task());

        assertThat(actual, notNullValue());
        assertThat(actual.getId(), equalTo(id));
    }

    @Test
    void updateWhenTaskNull() {
        when(taskRepository.save(null)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> taskService.create(null));
    }

    @Test
    void delete() {
        Task task = new Task();
        Long id = 100L;
        task.setId(id);

        when(taskRepository.existsById(any(Long.class))).thenReturn(true);

        var actual = taskService.delete(id);

        assertThat(actual, equalTo(true));
    }
}