package com.daaw.project.services;

import com.daaw.project.dto.AbsenceDto;
import com.daaw.project.model.absences;
import com.daaw.project.model.child;

import java.util.List;
import java.util.Optional;

public interface absencesService {
    AbsenceDto findById(Long id);
    List<AbsenceDto> findAll();
    AbsenceDto save(AbsenceDto absenceDto);
    void deleteById(Long id);
    List<AbsenceDto> getAllabsences();
    AbsenceDto addabsence(AbsenceDto absenceDto);
    List<absences> getAbsencesByChild(child child);
}
