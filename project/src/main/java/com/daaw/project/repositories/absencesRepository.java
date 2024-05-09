package com.daaw.project.repositories;

import com.daaw.project.model.absences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface absencesRepository extends JpaRepository<absences,Long> {
}
