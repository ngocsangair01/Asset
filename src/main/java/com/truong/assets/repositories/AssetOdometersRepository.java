package com.truong.assets.repositories;

import com.truong.assets.dao.AssetOdometers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetOdometersRepository extends JpaRepository<AssetOdometers,Long> {

}
