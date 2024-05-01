package br.com.xt.dio.spring.boot.gym.repository;

import br.com.xt.dio.spring.boot.gym.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByBirthDate(LocalDate dataDeNascimento);

    Student findById(Long id);
}
