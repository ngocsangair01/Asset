package com.truong.assets.repositories;

import com.truong.assets.dao.PMScheduleTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PMScheduleTypeRepository extends JpaRepository<PMScheduleTypes,Long> {
}
