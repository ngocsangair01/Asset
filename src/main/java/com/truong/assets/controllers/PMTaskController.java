package com.truong.assets.controllers;

import com.truong.assets.dao.Assets;
import com.truong.assets.dao.PMTasks;
import com.truong.assets.dto.AssetsDTO;
import com.truong.assets.dto.PMTasksDTO;
import com.truong.assets.exceptions.DuplicateException;
import com.truong.assets.exceptions.NotFoundException;
import com.truong.assets.repositories.PMTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PMTaskController {
    @Autowired
    private PMTaskRepository pmTaskRepository;
    @GetMapping("GetPMTasks")
    public ResponseEntity<?> findAllPMTasks() {
        if (pmTaskRepository.findAll().size()==0) {
            throw new DuplicateException("Have no PM Tasks");
        }
        return ResponseEntity.status(200).body(pmTaskRepository.findAll());
    }
    @PostMapping("AddPMTask")
    public ResponseEntity<?> createAssetGroups(@RequestBody PMTasksDTO pmTasksDTO) {
        PMTasks pmTasks = new PMTasks();
        pmTasks.setAssetID(pmTasksDTO.getAssetID());
        pmTasks.setTaskID(pmTasksDTO.getTaskID());
        pmTasks.setPMScheduleTypeID(pmTasksDTO.getPMScheduleTypeID());
        pmTasks.setScheduleDate(pmTasksDTO.getScheduleDate());
        pmTasks.setScheduleKilometer(pmTasksDTO.getScheduleKilometer());
        pmTasks.setTaskDone(pmTasksDTO.getTaskDone());
        pmTaskRepository.save(pmTasks);
        return ResponseEntity.status(200).build();
    }
    @PutMapping("UpdatePMTask")
    public ResponseEntity<?> updatePMTask(@RequestBody PMTasks pmTasks) {
        Optional<PMTasks> pmTasks1 = pmTaskRepository.findById(pmTasks.getID());
        if (pmTasks1.isEmpty()) {
            throw new NotFoundException("PM Task not found");
        }
        pmTaskRepository.save(pmTasks1.get());
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/PMTask/{IDPMTask}")
    public ResponseEntity<?> deletePMTask(@PathVariable(name = "IDPMTask")Long IDPMTask) {
        Optional<PMTasks> pmTasks = pmTaskRepository.findById(IDPMTask);
        if (pmTasks.isEmpty()){
            throw new NotFoundException("PM Task does not exists");
        }
        pmTaskRepository.deleteById(IDPMTask);
        return ResponseEntity.status(200).build();
    }
}
