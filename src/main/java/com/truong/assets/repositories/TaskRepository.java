package com.truong.assets.repositories;

import com.truong.assets.dao.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Tasks,Long> {
}
