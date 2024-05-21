package com.daaw.project.Controllers;

import com.daaw.project.dto.EvaluationDto;
import com.daaw.project.model.evaluation;
import com.daaw.project.services.evaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000")

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    private final evaluationService evaluationService;

    @Autowired
    public EvaluationController(evaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping("/child/post")
    public ResponseEntity<evaluation> createevaluation(@RequestBody EvaluationDto evaluationDto) {
        evaluation savedevaluation = evaluationService.saveEvaluation(evaluationDto);
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

    @GetMapping("/educator/{educatorId}/child/{childId}")
    public ResponseEntity<List<evaluation>> getEducatorEvalutationsPerChild(@PathVariable Long educatorId, @PathVariable Long childId) {
        List<evaluation> evaluations = evaluationService.getEvaluationsByEducatorIdAndChildId(educatorId, childId);
        return ResponseEntity.ok(evaluations);
    }
    @DeleteMapping("/evaluation/{evaluationId}")
        public ResponseEntity<Void> deleteEvaluation(@PathVariable Long evaluationId) {
        evaluationService.deleteEvaluationById(evaluationId);
    return ResponseEntity.noContent().build();
}
}
