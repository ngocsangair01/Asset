package com.truong.assets.repositories;

import com.truong.assets.dao.AssetPhotos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetPhotoRepository extends JpaRepository<AssetPhotos,Long> {
    List<AssetPhotos> findAllByAssetID(Long AssetID);
}
