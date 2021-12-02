package com.truong.assets.controllers;

import com.truong.assets.dao.AssetOdometers;
import com.truong.assets.dao.Assets;
import com.truong.assets.dto.AssetOdometersDTO;
import com.truong.assets.dto.AssetsDTO;
import com.truong.assets.exceptions.NotFoundException;
import com.truong.assets.repositories.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AssetController {
    @Autowired
    private AssetsRepository assetsRepository;
    @GetMapping("GetAssets")
    public ResponseEntity<?> findAllAssetOdometers() {
        if (assetsRepository.findAll().size()==0) {
            throw new NotFoundException("Have no Asset Odometer");
        }
        return ResponseEntity.status(200).body(assetsRepository.findAll());
    }
    @PostMapping("AddAsset")
    public ResponseEntity<?> createAssetGroups(@RequestBody AssetsDTO assetsDTO) {
        Assets assets = new Assets();
        assets.setAssetSN(assetsDTO.getAssetSN());
        assets.setAssetName(assetsDTO.getAssetName());
        assets.setDepartmentLocationID(assetsDTO.getDepartmentLocationID());
        assets.setEmployeeID(assetsDTO.getEmployeeID());
        assets.setAssetGroupID(assetsDTO.getAssetGroupID());
        assets.setDescription(assetsDTO.getDescription());
        assets.setWarrantyDate(assetsDTO.getWarrantyDate());
        assetsRepository.save(assets);
        return ResponseEntity.status(200).build();
    }
    @PutMapping("UpdateAsset")
    public ResponseEntity<?> updateAsset(@RequestBody Assets assets) {
        Optional<Assets> assets1 = assetsRepository.findById(assets.getID());
        if (assets1.isEmpty()) {
            throw new NotFoundException("Asset not found");
        }
        assetsRepository.save(assets1.get());
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/Asset/{IDAsset}")
    public ResponseEntity<?> deleteAssetOdometer(@PathVariable(name = "IDAsset")Long IDAsset) {
        Optional<Assets> assets = assetsRepository.findById(IDAsset);
        if (assets.isEmpty()){
            throw new NotFoundException("Asset does not exists");
        }
        assetsRepository.deleteById(IDAsset);
        return ResponseEntity.status(200).build();
    }

}
