package com.daaw.project.repositories;

import com.daaw.project.model.evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface evaluationRepository extends JpaRepository<evaluation, Long> {
    List<evaluation> findByChildId(Long childId);
    List<evaluation> findByEducatorId(Long educatorId);
}