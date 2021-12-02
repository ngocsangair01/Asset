package com.truong.assets.controllers;

import com.truong.assets.dao.DepartmentLocations;
import com.truong.assets.dao.Departments;
import com.truong.assets.dto.DepartmentLocationDTO;
import com.truong.assets.dto.DepartmentsDTO;
import com.truong.assets.exceptions.NotFoundException;
import com.truong.assets.repositories.DepartmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DepartmentController {
    private DepartmentRepository departmentRepository;
    @GetMapping("GetDepartments")
    public ResponseEntity<?> findAllDepartment() {
        if (departmentRepository.findAll().size()==0) {
            throw new NotFoundException("Have no department location");
        }
        return ResponseEntity.status(200).body(departmentRepository.findAll());
    }
    @PostMapping("Department/createDepartment")
    public ResponseEntity<?> createDeaprtment(@RequestBody DepartmentsDTO departmentsDTO) {
        Departments departments = new Departments();
        departments.setName(departmentsDTO.getName());
        departmentRepository.save(departments);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/Department/{idDepartment}")
    public ResponseEntity<?> deleteDepartment(@PathVariable(name = "idDepartment")Long idDepartment) {
        Optional<Departments> departments = departmentRepository.findById(idDepartment);
        if (departments.isEmpty()){
            throw new NotFoundException("Department Location does not exists");
        }
        departmentRepository.deleteById(idDepartment);
        return ResponseEntity.status(200).build();
    }

}
