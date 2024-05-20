package com.daaw.project.services;

import com.daaw.project.dto.EvaluationDto;
import com.daaw.project.model.evaluation;

import java.util.List;

public interface evaluationService {
    evaluation saveEvaluation(EvaluationDto evaluationDto);
    List<evaluation> getEvaluationsByChildId(Long childId);
    List<evaluation> getEvaluationsByEducatorId(Long educatorId);
}
