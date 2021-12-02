package com.truong.assets.repositories;

import com.truong.assets.dao.AssetTransferLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetTransferLogRepository extends JpaRepository<AssetTransferLogs,Long> {
}
