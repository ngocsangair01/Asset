package com.truong.assets.controllers;

import com.truong.assets.dao.AssetOdometers;
import com.truong.assets.dao.Assets;
import com.truong.assets.dto.AssetOdometersDTO;
import com.truong.assets.exceptions.NotFoundException;
import com.truong.assets.repositories.AssetOdometersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class AssetOdometerController {
    @Autowired
    private AssetOdometersRepository assetOdometersRepository;

    @GetMapping("GetAssetOdometers")
    public ResponseEntity<?> findAllAssetOdometers() {
        if (assetOdometersRepository.findAll().size()==0) {
            throw new NotFoundException("Have no Asset Odometer");
        }
        return ResponseEntity.status(200).body(assetOdometersRepository.findAll());
    }
    @PostMapping("AddAssetOdometers")
    public ResponseEntity<?> createAssetOdometer(@RequestBody AssetOdometersDTO assetOdometersDTO) {
        AssetOdometers assetOdometers = new AssetOdometers();
        assetOdometers.setAssetID(assetOdometersDTO.getAssetID());
        assetOdometers.setOdometerAmount(assetOdometersDTO.getOdometerAmount());
        assetOdometers.setReadDate(assetOdometersDTO.getReadDate());
        assetOdometersRepository.save(assetOdometers);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/AssetOdometer/{idAssetOdometer}")
    public ResponseEntity<?> deleteAssetOdometer(@PathVariable(name = "idAssetOdometer")Long idAssetOdometer) {
        Optional<AssetOdometers> assetOdometers = assetOdometersRepository.findById(idAssetOdometer);
        if (assetOdometers.isEmpty()){
            throw new NotFoundException("AssetOdometer does not exists");
        }
        assetOdometersRepository.deleteById(idAssetOdometer);
        return ResponseEntity.status(200).build();
    }
}
