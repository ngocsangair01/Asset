package com.truong.assets.repositories;

import com.truong.assets.dao.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments,Long> {
}
