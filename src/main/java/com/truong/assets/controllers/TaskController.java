package com.truong.assets.controllers;

import com.truong.assets.dao.Locations;
import com.truong.assets.dao.Tasks;
import com.truong.assets.dto.LocationDTO;
import com.truong.assets.dto.TaskDTO;
import com.truong.assets.exceptions.NotFoundException;
import com.truong.assets.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;
    @GetMapping("GetTasks")
    public ResponseEntity<?> findAllTasks() {
        if (taskRepository.findAll().size()==0) {
            throw new NotFoundException("Have no task");
        }
        return ResponseEntity.status(200).body(taskRepository.findAll());
    }
    @PostMapping("task/createTask")
    public ResponseEntity<?> createTask(@RequestBody TaskDTO taskDTO) {
        Tasks tasks = new Tasks();
        tasks.setName(taskDTO.getName());
        taskRepository.save(tasks);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/task/{IDTask}")
    public ResponseEntity<?> deleteTask(@PathVariable(name = "IDTask")Long IDTask) {
        Optional<Tasks> tasks = taskRepository.findById(IDTask);
        if (tasks.isEmpty()){
            throw new NotFoundException("Task does not exists");
        }
        taskRepository.deleteById(IDTask);
        return ResponseEntity.status(200).build();
    }
}
