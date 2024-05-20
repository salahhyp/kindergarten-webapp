package com.daaw.project.Impl;

import com.daaw.project.model.evaluation;
import com.daaw.project.repositories.evaluationRepository;
import com.daaw.project.services.evaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class evaluationServiceImpl implements evaluationService {

    private evaluationRepository evaluationRepository;

    @Autowired
    public evaluationServiceImpl(evaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public evaluation saveEvaluation(evaluation evaluation) {
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
