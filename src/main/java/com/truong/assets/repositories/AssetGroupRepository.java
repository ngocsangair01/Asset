package com.truong.assets.repositories;

import com.truong.assets.dao.AssetGroups;
import com.truong.assets.dao.Assets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetGroupRepository extends JpaRepository<AssetGroups,Long> {
}
