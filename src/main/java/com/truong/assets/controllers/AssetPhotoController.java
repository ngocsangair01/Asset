package com.truong.assets.controllers;

import com.truong.assets.dao.AssetPhotos;
import com.truong.assets.dao.Assets;
import com.truong.assets.dto.AssetPhotosDTO;
import com.truong.assets.dto.AssetsDTO;
import com.truong.assets.exceptions.DuplicateException;
import com.truong.assets.exceptions.NotFoundException;
import com.truong.assets.repositories.AssetPhotoRepository;
import com.truong.assets.repositories.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AssetPhotoController {

    @Autowired
    private AssetPhotoRepository assetPhotoRepository;

    @GetMapping("GetAssetsPhotos/{assetID}")
    public ResponseEntity<?> findAllAssetPhotoById(@PathVariable(name = "assetID")Long assetID) {
        List<AssetPhotos> assetPhotos = assetPhotoRepository.findAllByAssetID(assetID);
        if (assetPhotos.size()==0) {
            throw new NotFoundException("Have no Asset Photo");
        }
        return ResponseEntity.status(200).body(assetPhotos);
    }

    @PostMapping("AddAssetPhoto")
    public ResponseEntity<?> createAssetPhoto(@RequestBody AssetPhotosDTO assetPhotosDTO) {
        AssetPhotos assetPhotos = new AssetPhotos();
        assetPhotos.setAssetID(assetPhotosDTO.getAssetID());
        assetPhotos.setAssetPhoto(assetPhotosDTO.getAssetPhoto());
        assetPhotoRepository.save(assetPhotos);
        return ResponseEntity.status(200).build();
    }
    @PutMapping("UpdateAssetPhoto")
    public ResponseEntity<?> updateAssetPhoto(@RequestBody AssetPhotos assetPhotos) {
        Optional<AssetPhotos> assetPhotos1 = assetPhotoRepository.findById(assetPhotos.getID());
        if (assetPhotos1.isEmpty()) {
            throw new DuplicateException("Asset not found");
        }
        assetPhotoRepository.save(assetPhotos1.get());
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/Asset/{idAssetPhoto}")
    public ResponseEntity<?> deleteAssetPhoto(@PathVariable(name = "idAssetPhoto")Long idAssetPhoto) {
        Optional<AssetPhotos> assetPhotos = assetPhotoRepository.findById(idAssetPhoto);
        if (assetPhotos.isEmpty()){
            throw new NotFoundException("Asset does not exists");
        }
        assetPhotoRepository.deleteById(idAssetPhoto);
        return ResponseEntity.status(200).build();
    }
}
