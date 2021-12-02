package com.truong.assets.repositories;

import com.truong.assets.dao.DepartmentLocations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentLocationsRepository extends JpaRepository<DepartmentLocations,Long> {
}
