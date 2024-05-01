package br.com.xt.dio.spring.boot.gym.service;

import br.com.xt.dio.spring.boot.gym.dto.CreateStudentDTO;
import br.com.xt.dio.spring.boot.gym.dto.UpdateStudentDTO;
import br.com.xt.dio.spring.boot.gym.entity.Assessment;
import br.com.xt.dio.spring.boot.gym.entity.Student;

import java.util.List;

public interface IStudentService {

    Student create(CreateStudentDTO dto);

    Student getById(Long id);

    List<Student> getAll(String dataDeNascimento);

    Student update(Long id, UpdateStudentDTO dto);

    void delete(Long id);

    List<Assessment> getAllAssessmentsByStudentId(Long id);
}
