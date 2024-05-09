package com.daaw.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.daaw.project.model.visitor;
import org.springframework.stereotype.Repository;


@Repository
public interface visitorRepository extends JpaRepository<visitor,Long> {
}
