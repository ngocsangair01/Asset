package com.truong.assets.repositories;

import com.truong.assets.dao.PMTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PMTaskRepository extends JpaRepository<PMTasks,Long> {
}
