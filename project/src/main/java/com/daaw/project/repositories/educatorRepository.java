package com.daaw.project.repositories;

import com.daaw.project.model.educator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface educatorRepository extends JpaRepository<educator,Long> {
}
