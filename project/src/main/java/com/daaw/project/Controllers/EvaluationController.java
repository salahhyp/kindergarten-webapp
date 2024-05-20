package com.daaw.project.Controllers;

import com.daaw.project.model.evaluation;
import com.daaw.project.services.evaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    private final evaluationService evaluationService;

    @Autowired
    public EvaluationController(evaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping("/child/post")
    public ResponseEntity<evaluation> createevaluation(@RequestBody evaluation evaluation) {
        evaluation savedevaluation = evaluationService.saveEvaluation(evaluation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedevaluation);
    }

    @GetMapping("/child/{childId}")
    public ResponseEntity<List<evaluation>> getevaluationsByChildId(@PathVariable Long childId) {
        List<evaluation> evaluations = evaluationService.getEvaluationsByChildId(childId);
        return ResponseEntity.ok(evaluations);
    }

    @GetMapping("/educator/{educatorId}")
    public ResponseEntity<List<evaluation>> getevaluationsByEducatorId(@PathVariable Long educatorId) {
        List<evaluation> evaluations = evaluationService.getEvaluationsByEducatorId(educatorId);
        return ResponseEntity.ok(evaluations);
    }
}
