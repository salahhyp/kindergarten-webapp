package com.daaw.project.Impl;




import com.daaw.project.model.absences;
import com.daaw.project.repositories.absencesRepository;
import com.daaw.project.services.absencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class absencesServiceImpl implements absencesService {

    @Autowired
    private absencesRepository absencesRepository;

    @Override
    public absences findById(Long id) {
        Optional<absences> absence = absencesRepository.findById(id);
        return absence.orElse(null);
    }

    @Override
    public List<absences> findAll() {
        return absencesRepository.findAll();
    }

    @Override
    public absences save(absences absences) {
        return absencesRepository.save(absences);
    }

    @Override
    public void deleteById(Long id) {
        absencesRepository.deleteById(id);
    }

    @Override
    public absences addabsence(absences absences) {
        return absencesRepository.save(absences);
    }

    @Override
    public List<absences> getAllabsences() {
        return absencesRepository.findAll();
    }

    @Override
    public Optional<absences> getabsenceById(Long id) {
        return absencesRepository.findById(id);

    }

}
