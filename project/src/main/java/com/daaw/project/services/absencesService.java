package com.daaw.project.services;



import com.daaw.project.model.absences;

import java.util.List;
import java.util.Optional;

public interface absencesService {

    absences findById(Long id);
    List<absences> findAll();
    absences save(absences absences);
    void deleteById(Long id);

    Optional<absences> getabsenceById(Long id);

    List<absences> getAllabsences();

    absences addabsence(absences absences);
}
