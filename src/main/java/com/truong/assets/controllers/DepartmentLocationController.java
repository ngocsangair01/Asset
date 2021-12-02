package com.truong.assets.controllers;

import com.truong.assets.dao.DepartmentLocations;
import com.truong.assets.dao.Locations;
import com.truong.assets.dto.DepartmentLocationDTO;
import com.truong.assets.dto.LocationDTO;
import com.truong.assets.exceptions.NotFoundException;
import com.truong.assets.repositories.DepartmentLocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DepartmentLocationController {
    @Autowired
    private DepartmentLocationsRepository departmentLocationsRepository;
    @GetMapping("GetDepartmentLocations")
    public ResponseEntity<?> findAllDepartmentLocation() {
        if (departmentLocationsRepository.findAll().size()==0) {
            throw new NotFoundException("Have no department location");
        }
        return ResponseEntity.status(200).body(departmentLocationsRepository.findAll());
    }
    @PostMapping("DepartmentLocation/createDepartmentLocation")
    public ResponseEntity<?> createDeaprtmentLocation(@RequestBody DepartmentLocationDTO departmentLocationDTO) {
        DepartmentLocations departmentLocations = new DepartmentLocations();
        departmentLocations.setDepartmentID(departmentLocationDTO.getDepartmentID());
        departmentLocations.setLocationID(departmentLocationDTO.getLocationID());
        departmentLocations.setStartDate(departmentLocationDTO.getStartDate());
        departmentLocations.setEndDate(departmentLocationDTO.getStartDate());
        departmentLocationsRepository.save(departmentLocations);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/DepartmentLocation/{idDepartmentLocation}")
    public ResponseEntity<?> deleteDepartmentLocation(@PathVariable(name = "idDepartmentLocation")Long idDepartmentLocation) {
        Optional<DepartmentLocations> departmentLocations = departmentLocationsRepository.findById(idDepartmentLocation);
        if (departmentLocations.isEmpty()){
            throw new NotFoundException("Department Location does not exists");
        }
        departmentLocationsRepository.deleteById(idDepartmentLocation);
        return ResponseEntity.status(200).build();
    }
}
