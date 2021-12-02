package com.truong.assets.controllers;

import com.truong.assets.dao.AssetOdometers;
import com.truong.assets.dao.Locations;
import com.truong.assets.dto.AssetOdometersDTO;
import com.truong.assets.dto.LocationDTO;
import com.truong.assets.exceptions.NotFoundException;
import com.truong.assets.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;
    @GetMapping("GetLocations")
    public ResponseEntity<?> findAllLocation() {
        if (locationRepository.findAll().size()==0) {
            throw new NotFoundException("Have no location");
        }
        return ResponseEntity.status(200).body(locationRepository.findAll());
    }
    @PostMapping("Location/CreateLocation")
    public ResponseEntity<?> createLocation(@RequestBody LocationDTO locationDTO) {
        Locations locations = new Locations();
        locations.setName(locationDTO.getName());
        locationRepository.save(locations);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/Location/{IDLocation}")
    public ResponseEntity<?> deleteAssetOdometer(@PathVariable(name = "IDLocation")Long IDLocation) {
        Optional<Locations> locations = locationRepository.findById(IDLocation);
        if (locations.isEmpty()){
            throw new NotFoundException("AssetOdometer does not exists");
        }
        locationRepository.deleteById(IDLocation);
        return ResponseEntity.status(200).build();
    }
}
