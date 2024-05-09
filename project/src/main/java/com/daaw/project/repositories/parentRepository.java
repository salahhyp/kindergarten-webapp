package com.daaw.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.daaw.project.model.parent;
import org.springframework.stereotype.Repository;


@Repository
public interface parentRepository extends JpaRepository<parent,Long> {
}
