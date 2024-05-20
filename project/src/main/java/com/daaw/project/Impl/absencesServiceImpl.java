package com.daaw.project.Impl;

import com.daaw.project.dto.AbsenceDto;
import com.daaw.project.model.absences;
import com.daaw.project.model.child;
import com.daaw.project.model.session;
import com.daaw.project.repositories.absencesRepository;
import com.daaw.project.repositories.childRepository;
import com.daaw.project.repositories.sessionRepository;
import com.daaw.project.services.absencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class absencesServiceImpl implements absencesService {

    @Autowired
    private absencesRepository absencesRepository;

    @Autowired
    private childRepository childRepository;

    @Autowired
    private sessionRepository sessionRepository;

    @Override
    public AbsenceDto findById(Long id) {
        Optional<absences> absence = absencesRepository.findById(id);
        return absence.map(this::convertToDto).orElse(null);
    }

    @Override
    public List<AbsenceDto> findAll() {
        return absencesRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public AbsenceDto save(AbsenceDto absenceDto) {
        absences absence = convertToEntity(absenceDto);
        absences savedAbsence = absencesRepository.save(absence);
        return convertToDto(savedAbsence);
    }

    @Override
    public void deleteById(Long id) {
        absencesRepository.deleteById(id);
    }

    @Override
    public AbsenceDto addabsence(AbsenceDto absenceDto) {
        absences absence = convertToEntity(absenceDto);
        absences savedAbsence = absencesRepository.save(absence);
        return convertToDto(savedAbsence);
    }

    @Override
    public List<AbsenceDto> getAllabsences() {
        return absencesRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private AbsenceDto convertToDto(absences absence) {
        AbsenceDto dto = new AbsenceDto();
        dto.setId(absence.getId());
        dto.setDescription(absence.getDescription());
        dto.setJustification(absence.getJustification());
        dto.setChildId(absence.getChild().getId());
        dto.setSessionId(absence.getSession().getId());
        return dto;
    }

    private absences convertToEntity(AbsenceDto dto) {
        absences absence = new absences();
        absence.setId(dto.getId());
        absence.setDescription(dto.getDescription());
        absence.setJustification(dto.getJustification());

        Optional<child> child = childRepository.findById(dto.getChildId());
        Optional<session> session = sessionRepository.findById(dto.getSessionId());

        child.ifPresent(absence::setChild);
        session.ifPresent(absence::setSession);

        return absence;
    }
}
