package com.truong.assets.controllers;

import com.truong.assets.dao.PMScheduleModels;
import com.truong.assets.dao.PMScheduleTypes;
import com.truong.assets.dto.PMScheduleModelsDTO;
import com.truong.assets.dto.PMScheduleTypesDTO;
import com.truong.assets.exceptions.NotFoundException;
import com.truong.assets.repositories.PMScheduleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PMScheduleModelController {
    @Autowired
    private PMScheduleModelRepository pmScheduleModelRepository;
    @GetMapping("GetPMScheduleModels")
    public ResponseEntity<?> findAllPMScheduleType() {
        if (pmScheduleModelRepository.findAll().size()==0) {
            throw new NotFoundException("Have no PM Schedule Model");
        }
        return ResponseEntity.status(200).body(pmScheduleModelRepository.findAll());
    }
    @PostMapping("PMScheduleModels/createPMScheduleModel")
    public ResponseEntity<?> createLocation(@RequestBody PMScheduleModelsDTO pmScheduleModelsDTO) {
        PMScheduleModels pmScheduleModels = new PMScheduleModels();
        pmScheduleModels.setName(pmScheduleModelsDTO.getName());
        pmScheduleModels.setPMScheduleTypeID(pmScheduleModelsDTO.getPMScheduleTypeID());
        pmScheduleModelRepository.save(pmScheduleModels);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/PMScheduleType/{IDPMScheduleModel}")
    public ResponseEntity<?> deletePMScheduleType(@PathVariable(name = "IDPMScheduleModel")Long IDPMScheduleModel) {
        Optional<PMScheduleModels> pmScheduleModels = pmScheduleModelRepository.findById(IDPMScheduleModel);

        if (pmScheduleModels.isEmpty()){
            throw new NotFoundException("PMScheduleModel does not exists");
        }
        pmScheduleModelRepository.deleteById(IDPMScheduleModel);
        return ResponseEntity.status(200).build();
    }
}
