package br.com.xt.dio.spring.boot.gym.controller;

import br.com.xt.dio.spring.boot.gym.dto.CreateStudentDTO;
import br.com.xt.dio.spring.boot.gym.dto.UpdateStudentDTO;
import br.com.xt.dio.spring.boot.gym.entity.Assessment;
import br.com.xt.dio.spring.boot.gym.entity.Student;
import br.com.xt.dio.spring.boot.gym.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private IStudentService service;

    @GetMapping
    public List<Student> index(
            @RequestParam(value = "birthDate", required = false) String birthDate
    ) {
        return service.getAll(birthDate);
    }

    @GetMapping("/{id}")
    public Student show(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/assessments/{id}")
    public List<Assessment> getAllAssessmentsByStudentId(@PathVariable Long id) {
        return service.getAllAssessmentsByStudentId(id);
    }

    @PostMapping
    public Student create(@Valid @RequestBody CreateStudentDTO form) {
        return service.create(form);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @Valid @RequestBody UpdateStudentDTO form) {
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
