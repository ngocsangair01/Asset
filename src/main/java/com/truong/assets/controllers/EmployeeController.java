package com.truong.assets.controllers;

import com.truong.assets.dao.Employees;
import com.truong.assets.dao.Locations;
import com.truong.assets.dto.EmployeesDTO;
import com.truong.assets.dto.LocationDTO;
import com.truong.assets.exceptions.NotFoundException;
import com.truong.assets.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeesRepository employeesRepository;
    @GetMapping("GetEmployees")
    public ResponseEntity<?> findAllEmployee() {
        if (employeesRepository.findAll().size()==0) {
            throw new NotFoundException("Have no location");
        }
        return ResponseEntity.status(200).body(employeesRepository.findAll());
    }
    @PostMapping("Employee/createEmployee")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeesDTO employeesDTO) {
        Employees employees = new Employees();
        employees.setFirstName(employeesDTO.getFirstName());
        employees.setLastName(employeesDTO.getLastName());
        employees.setPhone(employeesDTO.getPhone());
        employeesRepository.save(employees);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/Employee/{idEmployees}")
    public ResponseEntity<?> deleteAssetOdometer(@PathVariable(name = "idEmployees")Long idEmployees) {
        Optional<Employees> employees = employeesRepository.findById(idEmployees);
        if (employees.isEmpty()){
            throw new NotFoundException("AssetOdometer does not exists");
        }
        employeesRepository.deleteById(idEmployees);
        return ResponseEntity.status(200).build();
    }
}
