package com.daaw.project.Impl;

import com.daaw.project.dto.EvaluationDto;
import com.daaw.project.model.child;
import com.daaw.project.model.educator;
import com.daaw.project.model.evaluation;
import com.daaw.project.repositories.childRepository;
import com.daaw.project.repositories.educatorRepository;
import com.daaw.project.repositories.evaluationRepository;
import com.daaw.project.services.evaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class evaluationServiceImpl implements evaluationService {

    private final evaluationRepository evaluationRepository;
    private final childRepository childRepository;
    private final educatorRepository educatorRepository;

    @Autowired
    public evaluationServiceImpl(evaluationRepository evaluationRepository, childRepository childRepository, educatorRepository educatorRepository) {
        this.evaluationRepository = evaluationRepository;
        this.childRepository = childRepository;
        this.educatorRepository = educatorRepository;
    }

    @Override
    public evaluation saveEvaluation(EvaluationDto evaluationDto) {
        child child = childRepository.findById(evaluationDto.getChildId())
                .orElseThrow(() -> new RuntimeException("Child not found"));
        educator educator = educatorRepository.findById(evaluationDto.getEducatorId())
                .orElseThrow(() -> new RuntimeException("Educator not found"));

        evaluation evaluation = new evaluation();
        evaluation.setChild(child);
        evaluation.setEducator(educator);
        evaluation.setMark(evaluationDto.getMark());
        evaluation.setComment(evaluationDto.getComment());

        return evaluationRepository.save(evaluation);
    }

    @Override
    public List<evaluation> getEvaluationsByChildId(Long childId) {
        return evaluationRepository.findByChildId(childId);
    }

    @Override
    public List<evaluation> getEvaluationsByEducatorId(Long educatorId) {
        return evaluationRepository.findByEducatorId(educatorId);
    }
}
