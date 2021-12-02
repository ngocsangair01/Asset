package com.truong.assets.repositories;

import com.truong.assets.dao.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Locations,Long> {
}
