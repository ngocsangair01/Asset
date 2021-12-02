package com.truong.assets.controllers;

import com.truong.assets.dao.AssetGroups;
import com.truong.assets.dao.AssetOdometers;
import com.truong.assets.dao.Assets;
import com.truong.assets.dto.AssetGroupsDTO;
import com.truong.assets.dto.AssetsDTO;
import com.truong.assets.exceptions.NotFoundException;
import com.truong.assets.repositories.AssetGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AssetGroupController {
    @Autowired
    private AssetGroupRepository assetGroupRepository;
    @GetMapping("GetAssetGroups")
    public ResponseEntity<?> findAllAssetOdometers() {
        if (assetGroupRepository.findAll().size()==0) {
            throw new NotFoundException("Have no Asset Odometer");
        }
        return ResponseEntity.status(200).body(assetGroupRepository.findAll());
    }
    @PostMapping("/AssetGroup/AddAssetGroups")
    public ResponseEntity<?> createAssetGroup(@RequestBody AssetGroupsDTO assetGroupsDTO) {
        AssetGroups assetGroups = new AssetGroups();
        assetGroups.setName(assetGroupsDTO.getName());
        assetGroupRepository.save(assetGroups);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/AssetGroup/{IDAssetGroup}")
    public ResponseEntity<?> deleteAssetOdometer(@PathVariable(name = "IDAssetGroup")Long IDAssetGroup) {
        Optional<AssetGroups> assetGroups = assetGroupRepository.findById(IDAssetGroup);
        if (assetGroups.isEmpty()){
            throw new NotFoundException("AssetOdometer does not exists");
        }
        assetGroupRepository.deleteById(IDAssetGroup);
        return ResponseEntity.status(200).build();
    }
}
