package br.com.xt.dio.spring.boot.gym.service;

import br.com.xt.dio.spring.boot.gym.dto.CreateAssessmentDTO;
import br.com.xt.dio.spring.boot.gym.dto.UpdateAssessmentDTO;
import br.com.xt.dio.spring.boot.gym.entity.Assessment;

import java.util.List;

public interface IAssessmentService {

    Assessment create(CreateAssessmentDTO dto);

    Assessment getById(Long id);

    List<Assessment> getAll();

    Assessment update(Long id, UpdateAssessmentDTO dto);

    void delete(Long id);
}
