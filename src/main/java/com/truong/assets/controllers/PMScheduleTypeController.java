package com.truong.assets.controllers;

import com.truong.assets.dao.Locations;
import com.truong.assets.dao.PMScheduleTypes;
import com.truong.assets.dto.LocationDTO;
import com.truong.assets.dto.PMScheduleTypesDTO;
import com.truong.assets.exceptions.NotFoundException;
import com.truong.assets.repositories.PMScheduleModelRepository;
import com.truong.assets.repositories.PMScheduleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PMScheduleTypeController {
    @Autowired
    PMScheduleTypeRepository pmScheduleTypeRepository;
    @GetMapping("GetPMScheduleTypes")
    public ResponseEntity<?> findAllPMScheduleType() {
        if (pmScheduleTypeRepository.findAll().size()==0) {
            throw new NotFoundException("Have no PM Schedule Type");
        }
        return ResponseEntity.status(200).body(pmScheduleTypeRepository.findAll());
    }
    @PostMapping("PMScheduleType/createPMScheduleType")
    public ResponseEntity<?> createLocation(@RequestBody PMScheduleTypesDTO pmScheduleTypesDTO) {
        PMScheduleTypes pmScheduleTypes = new PMScheduleTypes();
        pmScheduleTypes.setName(pmScheduleTypesDTO.getName());
        pmScheduleTypeRepository.save(pmScheduleTypes);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/PMScheduleType/{IDPMScheduleType}")
    public ResponseEntity<?> deletePMScheduleType(@PathVariable(name = "IDPMScheduleType")Long IDPMScheduleType) {
        Optional<PMScheduleTypes> pmScheduleTypes = pmScheduleTypeRepository.findById(IDPMScheduleType);

        if (pmScheduleTypes.isEmpty()){
            throw new NotFoundException("PMScheduleType does not exists");
        }
        pmScheduleTypeRepository.deleteById(IDPMScheduleType);
        return ResponseEntity.status(200).build();
    }
}
