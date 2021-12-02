package com.truong.assets.controllers;

import com.truong.assets.dao.AssetOdometers;
import com.truong.assets.dao.AssetTransferLogs;
import com.truong.assets.dto.AssetOdometersDTO;
import com.truong.assets.dto.AssetTransferLogsDTO;
import com.truong.assets.exceptions.NotFoundException;
import com.truong.assets.repositories.AssetTransferLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AssetTransferLogController {
    @Autowired
    private AssetTransferLogRepository assetTransferLogRepository;

    @GetMapping("GetAssetTransferLogs")
    public ResponseEntity<?> findAllAssetTransferLogs() {
        if (assetTransferLogRepository.findAll().size()==0) {
            throw new NotFoundException("Have no Asset Transfer Log");
        }
        return ResponseEntity.status(200).body(assetTransferLogRepository.findAll());
    }
    @PostMapping("AddTransferLogs")
    public ResponseEntity<?> createAssetOdometer(@RequestBody AssetTransferLogsDTO assetTransferLogsDTO) {
        AssetTransferLogs assetTransferLogs = new AssetTransferLogs();
        assetTransferLogs.setAssetID(assetTransferLogsDTO.getAssetID());
        assetTransferLogs.setFromAssetSN(assetTransferLogsDTO.getFromAssetSN());
        assetTransferLogs.setToAssetSN(assetTransferLogsDTO.getToAssetSN());
        assetTransferLogs.setFromAssetSN(assetTransferLogsDTO.getFromAssetSN());
        assetTransferLogs.setToDepartmentID(assetTransferLogsDTO.getToDepartmentLocationID());
        assetTransferLogRepository.save(assetTransferLogs);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/AssetTransferLog/{idAssetTransferLogs}")
    public ResponseEntity<?> deleteAssetTransferLog(@PathVariable(name = "idAssetTransferLogs")Long idAssetTransferLogs) {
        Optional<AssetTransferLogs> assetTransferLogs = assetTransferLogRepository.findById(idAssetTransferLogs);
        if (assetTransferLogs.isEmpty()){
            throw new NotFoundException("AssetOdometer does not exists");
        }
        assetTransferLogRepository.deleteById(idAssetTransferLogs);
        return ResponseEntity.status(200).build();
    }
}
