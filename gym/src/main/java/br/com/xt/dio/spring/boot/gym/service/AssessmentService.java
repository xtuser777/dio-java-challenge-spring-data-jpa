package br.com.xt.dio.spring.boot.gym.service;

import br.com.xt.dio.spring.boot.gym.dto.CreateAssessmentDTO;
import br.com.xt.dio.spring.boot.gym.dto.UpdateAssessmentDTO;
import br.com.xt.dio.spring.boot.gym.entity.Assessment;
import br.com.xt.dio.spring.boot.gym.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService implements IAssessmentService {

    @Autowired
    private AssessmentRepository repository;

    @Autowired
    private IStudentService studentService;

    @Override
    public Assessment create(CreateAssessmentDTO dto) {
        var assessment = this.convert(dto);

        return this.repository.save(assessment);
    }

    @Override
    public Assessment getById(Long id) {
        var assessment = repository.findById(id).orElse(null);
        if (assessment == null) {
            throw new RuntimeException("Assessment not found");
        } else return assessment;
    }

    @Override
    public List<Assessment> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Assessment update(Long id, UpdateAssessmentDTO dto) {
        var assessment = this.getById(id);
        assessment = this.convert(dto, assessment);

        return this.repository.save(assessment);
    }

    @Override
    public void delete(Long id) {
        var assessment = this.getById(id);
        repository.delete(assessment);
    }

    private Assessment convert(CreateAssessmentDTO dto) {
        var assessment = new Assessment();
        var student = studentService.getById(dto.getStudentId());
        assessment.setStudent(student);
        assessment.setWeight(dto.getWeight());
        assessment.setHeight(dto.getHeight());

        return assessment;
    }

    private Assessment convert(UpdateAssessmentDTO dto, Assessment assessment) {
        assessment.setWeight(dto.getWeight());
        assessment.setHeight(dto.getHeight());

        return assessment;
    }
}
