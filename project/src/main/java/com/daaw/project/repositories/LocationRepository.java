package com.daaw.project.repositories;
import com.daaw.project.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{
    List<Location> findByParentId(Long parentId);
}
