package com.daaw.project.services;

import com.daaw.project.model.evaluation;

import java.util.List;

public interface evaluationService {
    evaluation saveEvaluation(evaluation evaluation);
    List<evaluation> getEvaluationsByChildId(Long childId);
    List<evaluation> getEvaluationsByEducatorId(Long educatorId);
}