package com.truong.assets.repositories;

import com.truong.assets.dao.PMScheduleModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PMScheduleModelRepository extends JpaRepository<PMScheduleModels,Long> {
}
