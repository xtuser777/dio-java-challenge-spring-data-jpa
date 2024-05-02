package br.com.xt.dio.spring.boot.gym.controller;

import br.com.xt.dio.spring.boot.gym.dto.CreateAssessmentDTO;
import br.com.xt.dio.spring.boot.gym.dto.UpdateAssessmentDTO;
import br.com.xt.dio.spring.boot.gym.entity.Assessment;
import br.com.xt.dio.spring.boot.gym.service.IAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessments")
public class AssessmentsController {

    @Autowired
    private IAssessmentService service;

    @GetMapping
    public List<Assessment> index() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Assessment show(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Assessment create(@RequestBody CreateAssessmentDTO form) {
        return service.create(form);
    }

    @PutMapping("/{id}")
    public Assessment update(@PathVariable Long id, @RequestBody UpdateAssessmentDTO form) {
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
