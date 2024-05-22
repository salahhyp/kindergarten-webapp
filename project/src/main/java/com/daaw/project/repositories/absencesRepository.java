package com.daaw.project.repositories;

import com.daaw.project.dto.AbsenceDto;
import com.daaw.project.model.absences;
import com.daaw.project.model.child;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface absencesRepository extends JpaRepository<absences,Long> {

    List<absences> findByChild(child child);
}
